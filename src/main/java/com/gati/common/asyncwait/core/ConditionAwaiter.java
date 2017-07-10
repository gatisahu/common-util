/**
 * 
 */
package com.gati.common.asyncwait.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sahug
 *
 */
public class ConditionAwaiter {

	private final Callable<Boolean> asyncCondition;
	private final Condition condition;
	private final CountDownLatch latch;
	private Throwable throwable = null;

	public ConditionAwaiter(Callable<Boolean> asyncCondition, Condition condition) {
		this.asyncCondition = asyncCondition;
		this.condition = condition;
		this.latch = new CountDownLatch(1);
	}

	public void await() {
		boolean processCompleted = false;
		try {
			new WaitThread(asyncCondition, condition).start();
			Duration maxWaitTime = condition.getWaitDuration();

			if (maxWaitTime.getValue() == WaitStrategy.WAIT_FOREVER) {
				latch.await();
				processCompleted = true;
			} else {
				processCompleted = latch.await(maxWaitTime.getValue(), maxWaitTime.getTimeUnit());
			}

		} catch (Exception e) {
			throwable = e;
		} finally {
			if (throwable != null || !processCompleted) {
				throw new IllegalStateException("Not able to complete on time");

			}
		}
	}

	class WaitThread extends Thread {
		private final Callable<Boolean> asyncCondition;
		private final Condition condition;
		private Duration pollInterval;
		private Lock lock = new ReentrantLock();
		private java.util.concurrent.locks.Condition lockCondition = lock.newCondition();

		public WaitThread(Callable<Boolean> asyncCondition, Condition condition) {
			this.asyncCondition = asyncCondition;
			this.condition = condition;
			pollInterval = condition.getPollInterval();
		}

		@Override
		public void run() {
			lock.lock();
			try {
				try {
					while (!asyncCondition.call()) {
						lockCondition.await(pollInterval.getValue(), pollInterval.getTimeUnit());
					}
				} catch (InterruptedException e) {

				}

				if (asyncCondition.call()) {
					latch.countDown();
				}
			} catch (Exception e) {
				throwable = e;
			} finally {
				lock.unlock();
			}
		}

	}

}

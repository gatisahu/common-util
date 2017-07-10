/**
 * 
 */
package com.gati.common.asyncwait.core;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author sahug
 *
 */
public class ConditionBuilder {

	public static final Long ONE_HUNDRED_MILLISECONDS = 50l;
	private WaitStrategy waitStrategy = new NullWaitStartegy();
	private PollStrategy pollStrategy = new FixedPollStrategy(ONE_HUNDRED_MILLISECONDS, TimeUnit.MILLISECONDS);
	private String conditionName;

	public ConditionBuilder withMaxWaitTime(long maxWaitTime, TimeUnit unit) {
		this.waitStrategy = new FixedWaitStrategy(maxWaitTime, unit);
		return this;
	}

	public ConditionBuilder withPollInterval(long pollInterval, TimeUnit unit) {
		this.pollStrategy = new FixedPollStrategy(pollInterval, unit);
		return this;
	}

	public void until(Callable<Boolean> asyncCondition) {
		createAsyncCondition(asyncCondition);

	}

	private Condition build() {
		return new Condition(conditionName, waitStrategy, pollStrategy);
	}

	private void createAsyncCondition(Callable<Boolean> asyncCondition) {
		new ConditionAwaiter(asyncCondition, build()).await();

	}
}

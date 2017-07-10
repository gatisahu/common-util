/**
 * 
 */
package com.gati.common.asyncwait.core;

import java.util.concurrent.TimeUnit;

/**
 * @author sahug
 *
 */
public class FixedWaitStrategy implements WaitStrategy {
	private final Duration maximumWaitTime;

	public FixedWaitStrategy(long time, TimeUnit timeUnit) {
		this.maximumWaitTime = new Duration(time, timeUnit);
	}

	public Duration getMaxWaitTime() {
		return maximumWaitTime;
	}

}

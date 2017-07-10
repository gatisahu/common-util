/**
 * 
 */
package com.gati.common.asyncwait.core;

import java.util.concurrent.TimeUnit;

/**
 * @author sahug
 *
 */
public class FixedPollStrategy implements PollStrategy {

	private final Duration duration;

	public FixedPollStrategy(long maxWaitTime, TimeUnit unit) {
		this.duration = new Duration(maxWaitTime, unit);
	}

	public Duration getNextWaitTime() {
		return duration;
	}

}

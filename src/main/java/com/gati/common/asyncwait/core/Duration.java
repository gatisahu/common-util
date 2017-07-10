/**
 * 
 */
package com.gati.common.asyncwait.core;

import java.util.concurrent.TimeUnit;

/**
 * @author sahug
 *
 */
public class Duration {

	
	private final long time;

	private final TimeUnit timeUnit;

	public Duration(long time, TimeUnit timeUnit) {
		this.time = time;
		this.timeUnit = timeUnit;
	}

	public long getValue() {
		return time;
	}

	public TimeUnit getTimeUnit() {
		return timeUnit;
	}

}

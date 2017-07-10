/**
 * 
 */
package com.gati.common.asyncwait.core;

/**
 * @author sahug
 *
 */
public class NullWaitStartegy implements WaitStrategy {

	private final Duration duration;

	public NullWaitStartegy() {
		this.duration = new Duration(-1, null);
	}

	public Duration getMaxWaitTime() {
		return duration;
	}

}

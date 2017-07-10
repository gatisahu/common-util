/**
 * 
 */
package com.gati.common.asyncwait.core;

/**
 * @author sahug
 *
 */
public interface WaitStrategy {
	public static final long WAIT_FOREVER = -1;

	public Duration getMaxWaitTime();

}

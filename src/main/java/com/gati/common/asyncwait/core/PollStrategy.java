/**
 * 
 */
package com.gati.common.asyncwait.core;

/**
 * @author sahug
 *
 */
public interface PollStrategy {
	
	public Duration getNextWaitTime();

}

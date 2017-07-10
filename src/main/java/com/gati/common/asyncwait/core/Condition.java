/**
 * 
 */
package com.gati.common.asyncwait.core;

/**
 * @author sahug
 *
 */
public class Condition {

	private final WaitStrategy waitStrategy;

	private final PollStrategy pollStrategy;
	
	private final String conditionName;

	public Condition(String conditionName, WaitStrategy waitStrategy, PollStrategy pollStrategy) {
		this.conditionName = conditionName;
		this.waitStrategy = waitStrategy;
		this.pollStrategy = pollStrategy;
	}
	
	public Duration getWaitDuration(){
		return waitStrategy.getMaxWaitTime();
	}
	public Duration getPollInterval(){
		return pollStrategy.getNextWaitTime();
	}
}

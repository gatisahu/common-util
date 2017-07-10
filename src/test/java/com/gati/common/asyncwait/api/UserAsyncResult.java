/**
 * 
 */
package com.gati.common.asyncwait.api;

import java.util.concurrent.Callable;

/**
 * @author sahug
 *
 */
public class UserAsyncResult implements Callable<Boolean> {
	private final UserRepository userRepository;

	public UserAsyncResult(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public Boolean call() {
		return userRepository.getSize() == 1;
	}
}

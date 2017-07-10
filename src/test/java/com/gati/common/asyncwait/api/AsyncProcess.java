package com.gati.common.asyncwait.api;

public class AsyncProcess {
	private final UserRepository userRepository;

	public AsyncProcess(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void perform(final long time) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(time);
					userRepository.add("gati");
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});
		thread.start();
	}
}

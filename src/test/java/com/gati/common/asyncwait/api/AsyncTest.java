package com.gati.common.asyncwait.api;

import static com.gati.common.asyncwait.api.AsyncWait.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;

public class AsyncTest {

	@Test
	public void shouldBlocksAutomatically() throws Exception {
		UserRepository repository = new UserRepository();
		new AsyncProcess(repository).perform(600l);
		await().until(new UserAsyncResult(repository));
		assertEquals(1, repository.getSize());
	}
	@Test
	public void shouldBlocksAutomaticallyWithMaximumWaitTime_1() throws Exception {
		UserRepository repository = new UserRepository();
		new AsyncProcess(repository).perform(10);
		await().withMaxWaitTime(600, TimeUnit.MILLISECONDS).until(new UserAsyncResult(repository));
		assertEquals(1, repository.getSize());
	}
	
	@Test
	public void shouldBlocksAutomaticallyWithMaximumWaitTime_2() throws Exception {
		try{
		UserRepository repository = new UserRepository();
		new AsyncProcess(repository).perform(15);
		await().withMaxWaitTime(10, TimeUnit.MILLISECONDS).until(new UserAsyncResult(repository));
		assertEquals(1, repository.getSize());
		fail("should throw IllegalStateException ");
		}catch(IllegalStateException e){
			
		}
	}
	@Test
	public void shouldBlocksAutomaticallyWithMaximumWaitTime_3() throws Exception {
		try{
		UserRepository repository = new UserRepository();
		new AsyncProcess(repository).perform(15);
		await().withMaxWaitTime(10, TimeUnit.MILLISECONDS).until(new UserAsyncResult(repository));
		assertEquals(1, repository.getSize());
		fail("should throw IllegalStateException ");
		}catch(IllegalStateException e){
			
		}
	}

}

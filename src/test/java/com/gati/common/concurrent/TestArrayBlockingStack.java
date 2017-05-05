package com.gati.common.concurrent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.ExecutorService;

import org.junit.Test;

public class TestArrayBlockingStack {

	private ArrayBlockingStack<String> createNewStack(int initialCapacity) {
		return new ArrayBlockingStack<String>(initialCapacity);
	}

	private ExecutorService executor;

	@Test
	public void should_test_empty_stack() {
		ArrayBlockingStack<String> stack = createNewStack(1);
		assertTrue("New stack is empty", stack.empty());
		assertEquals("New stack has size zero", 0, stack.size());
		try {
			stack.push("Item");
			stack.push("Item1");
			fail("push() should have thrown EmptyStackException");
		} catch (final IllegalStateException e) {
			// Expected result
		}
	}

	@Test
	public void should_test_multithreadadd() {

	}

}

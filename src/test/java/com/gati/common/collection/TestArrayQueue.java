package com.gati.common.collection;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayQueue {

	@Test
	public void should_test_empty_queue() {
		ArrayQueue<String> testQueue = new ArrayQueue<String>();
		assertEquals(0, testQueue.size());
		assertNull(testQueue.poll());
		assertTrue(testQueue.add("First Item"));
		assertEquals(1, testQueue.size());
		assertEquals("First Item", testQueue.poll());
		assertEquals(0, testQueue.size());
	}

	@Test
	public void should_test_add() {
		ArrayQueue<String> testQueue = new ArrayQueue<String>();
		testQueue.add("Item1");
		assertEquals("Item1", testQueue.poll());
	}
	@Test
	public void should_test_size() {
		ArrayQueue<String> testQueue = new ArrayQueue<String>(4);
		testQueue.add("Item1");
		assertEquals(1, testQueue.size());
		testQueue.add("Item2");
		assertEquals(2, testQueue.size());
		testQueue.add("Item3");
		assertEquals(3, testQueue.size());
		testQueue.add("Item4");
		assertEquals(4, testQueue.size());
		assertEquals("Item1", testQueue.poll());
		assertEquals(3, testQueue.size());
		assertEquals("Item2", testQueue.poll());
		assertEquals(2, testQueue.size());
		assertEquals("Item3", testQueue.poll());
		assertEquals(1, testQueue.size());
	}

	@Test
	public void should_test_addpoll() {
		ArrayQueue<String> testQueue = new ArrayQueue<String>(5);
		for(int i=0;i<5;i++){
			assertTrue(testQueue.add("Item"+i));
		}
		assertEquals(5, testQueue.size());
		assertEquals("Item0", testQueue.poll());
		assertEquals("Item1", testQueue.poll());
		assertEquals(3, testQueue.size());
		assertTrue(testQueue.add("New_Item1"));
		assertTrue(testQueue.add("New_Item2"));
		assertEquals(5, testQueue.size());
		assertEquals("Item2", testQueue.poll());
		assertEquals("Item3", testQueue.poll());
		assertEquals("Item4", testQueue.poll());
		assertEquals("New_Item1", testQueue.poll());
		assertEquals("New_Item2", testQueue.poll());
	}
}

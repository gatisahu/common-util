package com.gati.common.collection;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class TestLinkedListStack {

	private Stack<String> createNewStack() {
		return new LinkedListStack<String>();
	}

	@Test
	public void should_test_empty_stack() {
		Stack<String> stack = createNewStack();
		assertTrue("New stack is empty", stack.empty());
		assertEquals("New stack has size zero", 0, stack.size());
		try {
			stack.peek();
			fail("peek() should have thrown EmptyStackException");
		} catch (final EmptyStackException e) {
			// Expected result
		}

		try {
			stack.pop();
			fail("pop() should have thrown EmptyStackException");
		} catch (final EmptyStackException e) {
			// Expected result
		}
	}

	@Test
	public void should_test_push() {
		Stack<String> stack = createNewStack();
		stack.push("Item");
		assertTrue("Stack is not empty", !stack.empty());
		assertEquals("Stack size is one", 1, stack.size());
		assertEquals("Top item is 'Item'", "Item", stack.peek());
		assertEquals("Stack size is one", 1, stack.size());
	}

	@Test
	public void should_test_multiple_push() {
		Stack<String> stack = createNewStack();
		int iteration = 10;
		// Push multiple item

		for (int i = 0; i < iteration; i++) {
			stack.push("Item" + i);
			assertTrue("Stack is not empty", !stack.empty());
			assertEquals("Stack size is " + i + 1, i + 1, stack.size());
			assertEquals("Top item is Item" + i, "Item" + i, stack.peek());
			assertEquals("Stack size is " + i + 1, i + 1, stack.size());
		}
	}

	@Test
	public void should_test_multiple_push_pop_peek() {
		Stack<String> stack = createNewStack();
		stack.push("Item");
		assertTrue("Stack is not empty", !stack.empty());
		assertEquals("Stack size is one", 1, stack.size());
		assertEquals("Top item is 'Item'", "Item", (String) stack.peek());
		assertEquals("Stack size is one", 1, stack.size());

		stack.push("Item2");
		assertEquals("Stack size is two", 2, stack.size());
		assertEquals("Top item is 'Item2'", "Item2", stack.peek());
		assertEquals("Stack size is two", 2, stack.size());

		assertEquals("Popped item is 'Item2'", "Item2", stack.pop());
		assertEquals("Top item is 'Item'", "Item", stack.peek());
		assertEquals("Stack size is one", 1, stack.size());

		assertEquals("Popped item is 'Item'", "Item", stack.pop());
		assertEquals("Stack size is zero", 0, stack.size());

	}

	@Test
	public void should_test_Search() {
		Stack<String> stack = createNewStack();
		stack.push("Object1");
		stack.push("Object2");
		stack.push("Object3");
		stack.push("Object4");
		stack.push("Object5");
		assertTrue("Stack is not empty", !stack.empty());
		assertEquals("Top item is 'Object5'", "Object5", stack.peek());
		assertEquals("Stack size is one", 5, stack.size());

		assertEquals("Top item is 'Object5'", 1, stack.Search("Object5"));
		assertEquals("Next Item is 'Object4'", 2, stack.Search("Object4"));
		assertEquals("Next Item is 'Object3'", 3, stack.Search("Object3"));
		assertEquals("Next Item is 'Object2'", 4, stack.Search("Object2"));
		assertEquals("Next Item is 'Object1'", 5, stack.Search("Object1"));
		assertEquals("Cannot find 'MissingObject'", -1, stack.Search("MissingObject"));
	}
}

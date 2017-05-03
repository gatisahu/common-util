/**
 * 
 */
package com.gati.common.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * An implementation of the {@link java.util.Stack} API that is based on an
 * ArrayList instead of a Vector, so it is not synchronized to protect against
 * multi-threaded access.
 * 
 * @author sahug
 *
 */
public class ArrayStack<E> implements Stack<E> {

	private static final int DEFAULT_INITIAL_CAPACITY = 15;
	private int top = -1;
	private int capacityIncrement;
	private E[] data;

	public ArrayStack() {
		this.data = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public ArrayStack(int initialCapacity) {
		if (initialCapacity >= 0) {
			this.data = (E[]) new Object[initialCapacity];
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}

	}

	public E push(E item) {
		ensureCapacity(top + 1);
		top++;
		data[top] = item;
		return item;
	}

	public E pop() throws EmptyStackException {
		E item = peek();
		data[top] = null;
		top--;
		return item;
	}

	public E peek() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException();
		}
		E item = data[top];
		return item;
	}

	public int Search(E item) {
		int i = top;
		int n = 1;
		while (i >= 0) {
			E currentItem = data[i];
			if ((item == null && currentItem == null) || (item != null && item.equals(currentItem))) {
				return n;
			}
			i--;
			n++;
		}
		return -1;
	}

	public void clear() {
		for (int i = 0; i < top; i++)
			data[i] = null;
		top = -1;
	}

	public boolean empty() {
		return top == -1;
	}

	public int size() {
		return top + 1;
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity - (data.length - 1) > 0) {
			increaseCapacity(minCapacity);
		}

	}

	private void increaseCapacity(int minCapacity) {
		int oldCapacity = data.length;
		int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		data = Arrays.copyOf(data, newCapacity);
	}
}

/**
 * 
 */
package com.gati.common.collection;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * @author gati.sahu@gmail.com
 *
 */
public class ArrayQueue<E> extends AbstractQueue<E> {

	private static final int DEFAULT_INITIAL_CAPACITY = 15;

	/** The queued items */
	private final E[] items;

	/** items index for next take, poll, peek or remove */
	private int takeIndex;

	/** items index for next put, offer, or add */
	private int putIndex;

	/** Number of elements in the queue */
	private int count;

	public ArrayQueue() {

		this(DEFAULT_INITIAL_CAPACITY);
	}

	public ArrayQueue(int capacity) {
		super();
		items = (E[]) new Object[capacity];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Queue#offer(java.lang.Object)
	 */
	public boolean offer(E item) {
		if (count == items.length) {
			return false;
		}
		items[putIndex] = item;
		putIndex++;
		if (putIndex == items.length) {
			putIndex = 0;
		}
		count++;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Queue#poll()
	 */
	public E poll() {
		if (count == 0) {
			return null;
		}
		E item = items[takeIndex];
		items[takeIndex] = null;
		takeIndex++;
		count--;
		if (takeIndex == items.length) {
			takeIndex = 0;
		}
		return item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Queue#peek()
	 */
	public E peek() {
		if (count == 0) {
			return null;
		}
		E item = items[takeIndex];
		return item;
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		return count;
	}

	/**
	 * Returns the number of additional elements that this queue can ideally (in
	 * the absence of memory or resource constraints) accept without blocking.
	 * This is always equal to the initial capacity of this queue less the
	 * current {@code size} of this queue.
	 *
	 * @return
	 */
	public int remainingCapacity() {
		return items.length - count;
	}
}

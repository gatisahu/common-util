package com.gati.common.concurrent;

import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gati.sahu@gmail.com
*/
public class ArrayBlockingStack<E> implements BlockingStack<E> {

	private int top = -1;
	private final E[] data;
	private final ReentrantLock lock;
	private final Condition notEmpty;
	private final Condition notFull;

	public ArrayBlockingStack(int capacity) {
		this(capacity, false);
	}

	public ArrayBlockingStack(int capacity, boolean fair) {
		this.data = (E[]) new Object[capacity];
		lock = new ReentrantLock(fair);
		notEmpty = lock.newCondition();
		notFull = lock.newCondition();
	}

	public E push(E item) {
		if (add(item)) {
			return item;
		} else {
			throw new IllegalStateException("Stack full");
		}
	}

	public boolean add(E item) {
		checkNotNull(item);
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			if (top == data.length - 1)
				return false;
			else {
				doPush(item);
				return true;
			}
		} finally {
			lock.unlock();
		}
	}

	public E pushWithWait(E item) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	public E pushWithWait(E item, long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}

	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}

	public E popWithWait() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	public E popWithWait(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
	private void doPush(E item) {
		top++;
		data[top] = item;
		notEmpty.signal();
	}

	public int Search(E item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean empty() {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			return top ==-1;
		} finally {
			lock.unlock();
		}
	}

	public int size() {
		final ReentrantLock lock = this.lock;
		lock.lock();
		try {
			return top + 1;
		} finally {
			lock.unlock();
		}

	}

	private static void checkNotNull(Object v) {
		if (v == null)
			throw new NullPointerException();
	}
}

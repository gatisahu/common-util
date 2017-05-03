package com.gati.common.collection;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

	private final LinkedList<E> linkedList;

	public LinkedListStack() {
		linkedList = new LinkedList<E>();
	}

	public E push(E item) {
		linkedList.add(item);
		return item;
	}

	public E pop() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException();
		}
		return linkedList.removeLast();
	}

	public E peek() throws EmptyStackException {
		if (empty()) {
			throw new EmptyStackException();
		}
		return linkedList.getLast();
	}

	public int Search(E item) {
		int index=linkedList.lastIndexOf(item);
		if(index==-1)
			return index;
		int searchIndex=size()-index;
		return searchIndex;
	}

	public boolean empty() {
		return linkedList.isEmpty();
	}

	public int size() {
		return linkedList.size();
	}

}

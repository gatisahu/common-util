/**
 * 
 */
package com.gati.common.collection;

import java.util.EmptyStackException;

/**
 * @author sahug
 *
 */
public interface Stack<E> {

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param item   item item to be added.
	 * @return the item just pushed
	 */
	public E push(E item);

	/**
	 * Pops the top item off of this stack and return it.
	 * 
	 * @return the top item on the stack
	 * @throws EmptyStackException  if the stack is empty
	 */
	public E pop() throws EmptyStackException;
	
	/**
	 * Returns the top item off of this stack without removing it.
	 * 
	 * @return the top item on the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public E peek() throws EmptyStackException;
	
	/**
	 * Returns the one-based position of the distance from the top that the
	 * specified object exists on this stack, where the top-most element is
	 * considered to be at distance <code>1</code>.
	 * @return
	 */
	public int Search(E item);
	
	/**
	 * Return true if this stack is currently empty.
	 * 
	 * @return true if the stack is currently empty.
	 */
	public boolean empty();
	
	/**
	 * Returns the number of elements in this stack.
	 * 
	 * @return the number of elements in this stack.
	 */
	public int size();

}

/**
 * 
 */
package com.gati.common.concurrent;

import java.util.concurrent.TimeUnit;

import com.gati.common.collection.Stack;

/**
 * A Stck interface that additionally supports operations that wait for the
 * stack to become non-empty when doing pop an element, and wait for space to
 * become available in the stack when pushing an element. 
 * Blocking stack methods come in four forms 
 * 
 * 1.If  handling operations that cannot be satisfied immediately then throw
 * exception i.e if Pop operation apply on empty stack it will throw exception.
 * 
 * 2.If  handling operations that cannot be satisfied immediately then return false
 * i.e if Pop operation apply on empty stack it will return false.
 * 
 * 3.If  handling operations that cannot be satisfied immediately then
 * blocks the current thread indefinitely until the operation can succeed.
 * 
 * 4.If  handling operations that cannot be satisfied immediately then
 * blocks for only a given maximum time limit before giving up
 * 
 * @author gati.sahu@gmail.com
 *
 */
public interface BlockingStack<E> extends Stack<E> {
	
	/**
	 * Pushes an item onto the top of this stack. if it is possible to do
     * so immediately without violating capacity restrictions, returning
     * {@code true} upon success and {@code false} if no space is currently
     * available.
     * 
	 * @param item   item item to be added
	 * @return {@code true} if the element was added to this stack, else
     *         {@code false}
     *         
	 */
	public boolean add(E item);
	
	/**
	 * Pushes an item onto the top of this stack waiting if necessary  for space to
	 * become available.
	 * 
	 * @param item item to be added
	 * @return the item just pushed
	 * @throws InterruptedException if interrupted while waiting
	 */
	public E pushWithWait(E item ) throws InterruptedException;
	
	/**
	 * Pushes an item onto the top of this stack waiting if necessary waiting up to the
     * specified wait time if necessary for space to become available.
	 * 
	 * @param item item to be added
	 * @param timeout how long to wait before giving up, in units of
     *        {@code unit}
	 * @param unit a {@code TimeUnit} determining how to interpret the
     *        {@code timeout} parameter
	 * @return the item just pushed
	 * @throws InterruptedException if interrupted while waiting
	 */
	public E pushWithWait(E item, long timeout, TimeUnit unit) throws InterruptedException;
	
	/**
	 * Pops the top item off of this stack and return it.if it is possible to do
     * so immediately , returning  {@code true} upon success and {@code false}
     * if no space is currently available.
     * 
	 * @return {@code true} if the element was removed from top of the  stack, else
     *         {@code false}
	 */
	public boolean remove();
	
	/**
	 * Pops the top item off of this stack and return it waiting if necessary  for item to
	 * become available.
	 * 
	 * @return the top item on the stack
	 * @throws InterruptedException if interrupted while waiting
	 */
	public E popWithWait() throws InterruptedException;
	
	/**
	 * Pops the top item off of this stack and return it if necessary waiting up to the
     * specified wait time if necessary for item to become available.
	 * 
	 * @param timeout how long to wait before giving up, in units of
     *        {@code unit}
	 * @param unit  a {@code TimeUnit} determining how to interpret the
     *        {@code timeout} parameter
	 * @return the top item on the stack
	 * @throws InterruptedException if interrupted while waiting
	 */
	public E popWithWait(long timeout, TimeUnit unit) throws InterruptedException;

}

/**
 * 
 */
package com.gati.objectpool.core;

/**
 * @author sahug
 *
 */
public class PoolObjectWrapper<T> {

	private final T object;
	private final long createTime = System.currentTimeMillis();

	public PoolObjectWrapper(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}
	public long getCreatedTime(){
		return createTime;
	}
}

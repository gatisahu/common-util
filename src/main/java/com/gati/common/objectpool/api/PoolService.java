/**
 * 
 */
package com.gati.common.objectpool.api;

/**
 * @author sahug
 *
 */
public interface PoolService<T> extends ObjectPool<T> {

	int getNumIdel();

	int getNumActive();

	boolean isClose();

	void close();

	void clear();

}

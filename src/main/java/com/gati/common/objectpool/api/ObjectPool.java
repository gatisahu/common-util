/**
 * 
 */
package com.gati.common.objectpool.api;

/**
 * @author sahug
 *
 */
public interface ObjectPool<T> {

	T borrowObject() throws Exception;

	void returnObject(T Object) throws Exception;
    
	void invalidateObject(T obj) throws Exception;
}

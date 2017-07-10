/**
 * 
 */
package com.gati.common.objectpool.api;

import com.gati.objectpool.core.PoolObjectWrapper;

/**
 * @author sahug
 *
 */
public interface PoolObjectFactory<T> {

	PoolObjectWrapper<T> createObject();

	boolean validateObjectBeforeTake(PoolObjectWrapper<T> poolObject);

	void destroyObject(PoolObjectWrapper<T> poolObject);

	boolean validateObjectBeforeRestore(PoolObjectWrapper<T> poolObject);

}

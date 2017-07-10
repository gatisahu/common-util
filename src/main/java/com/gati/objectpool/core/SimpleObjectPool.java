/**
 * 
 */
package com.gati.objectpool.core;

import com.gati.common.objectpool.api.PoolService;

/**
 * @author sahug
 *
 */
public class SimpleObjectPool<T> implements PoolService<T> {

	@Override
	public T borrowObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void returnObject(T Object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void invalidateObject(T obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNumIdel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumActive() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

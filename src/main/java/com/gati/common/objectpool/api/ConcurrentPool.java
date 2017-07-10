package com.gati.common.objectpool.api;

import java.util.concurrent.TimeUnit;

public interface ConcurrentPool<T> extends ObjectPool<T> {

	T borrowObject(long timeout, TimeUnit unit) throws Exception;

	T borrowObjectUninterruptibly() throws Exception;

}

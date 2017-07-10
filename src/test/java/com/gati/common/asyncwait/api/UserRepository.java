/**
 * 
 */
package com.gati.common.asyncwait.api;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sahug
 *
 */
public class UserRepository {
	private Set<String> set = Collections.newSetFromMap(new ConcurrentHashMap<String, Boolean>());

	public void add(String userName){
		set.add(userName);
	}
	public int getSize(){
		return set.size();
	}
}

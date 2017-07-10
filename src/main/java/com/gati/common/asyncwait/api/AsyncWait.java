/**
 * 
 */
package com.gati.common.asyncwait.api;

import com.gati.common.asyncwait.core.ConditionBuilder;

/**
 * @author sahug
 *
 */
public class AsyncWait {

	public static ConditionBuilder await() {
		return new ConditionBuilder();

	}

}

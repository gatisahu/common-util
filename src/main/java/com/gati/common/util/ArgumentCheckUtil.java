/**
 * 
 */
package com.gati.common.util;

import static java.lang.String.format;

import java.util.Collection;

/**
 * A utility class for validating arguments and state.
 * 
 * @author gati.sahu@gmail.com
 *
 */
public class ArgumentCheckUtil {

	/**
	 * 
	 * @param argument
	 * @param argName
	 * @return
	 */
	public static <E> E notNull(E argument, String argName) {
		if (argument == null) {
			throw new IllegalArgumentException(format("Argument '%s' cannot  be null", argName));
		}
		return argument;
	}

	/**
	 * 
	 * @param val1
	 * @param name1
	 * @param val2
	 * @param name2
	 */
	public static <E> void notNull(E argument1, String argName1, E argument2, String argName2) {
		notNull(argument1, argName1);
		notNull(argument2, argName2);
	}

	public static <E> void notNull(E argument1, String argName1, E argument2, String argName2, E argument3,
			String argName3) {
		notNull(argument1, argName1);
		notNull(argument2, argName2);
		notNull(argument3, argName3);

	}

	public static <E> void notNull(E argument1, String argName1, E argument2, String argName2, E argument3,
			String argName3, E argument4, String argName4) {
		notNull(argument1, argName1);
		notNull(argument2, argName2);
		notNull(argument3, argName3);
		notNull(argument4, argName4);

	}
	
	public static Collection<?> notEmpty(Collection<?> c, String name) {
        notNull(c, name);

        if (c.isEmpty())
        	throw new IllegalArgumentException("Argument is invalid: " + name + "must not be empty.");
		return c;
    }

	/**
	 * 
	 * @param arr
	 * @param name
	 * @return
	 */
	public static <T> T[] notEmpty(T[] arr, String name) {
		notNull(arr, name);

		if (arr.length == 0)
			throw new IllegalArgumentException("Argument is invalid: " + name + "must not be empty.");
		return arr;
	}

	public static int[] notEmpty(int[] arr, String name) {
		notNull(arr, name);

		if (arr.length == 0)
			throw new IllegalArgumentException("Argument is invalid: " + name + "must not be empty.");
		return arr;
	}

	public static long[] notEmpty(long[] arr, String name) {
		notNull(arr, name);

		if (arr.length == 0)
			throw new IllegalArgumentException("Argument is invalid: " + name + "must not be empty.");
		return arr;
	}

	/**
	 * 
	 * @param value
	 * @param name
	 * @return
	 */
	public static String notNullOrEmpty(String value, String name) {
		notNull(value, name);

		if (value.trim().length() == 0)
			throw new IllegalArgumentException("Argument is invalid: " + name + "must not be null or empty.");
		return value;
	}

	private ArgumentCheckUtil() {
	}
}

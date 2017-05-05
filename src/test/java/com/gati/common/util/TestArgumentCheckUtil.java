package com.gati.common.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestArgumentCheckUtil {

	@Test
	public void testNotNullArgument() {

		try {
			String str = null;
			ArgumentCheckUtil.notNull(str, "testArgument");
			fail("should have thrown EmptyStackException");
		} catch (final IllegalArgumentException e) {
			System.out.println(e);
		}

		try {
			List list = null;
			ArgumentCheckUtil.notNull(list, "listArgument");
			fail("should have thrown EmptyStackException");
		} catch (final IllegalArgumentException e) {
			System.out.println(e);
		}

	}
	
	@Test
	public void testNotEmptyArgument() {

		try {
			long[] str ={};
			ArgumentCheckUtil.notEmpty(str, "testArgument");
			fail("should have thrown EmptyStackException");
		} catch (final IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
			Object[] obj ={};
			ArgumentCheckUtil.notEmpty(obj, "testArgument");
			fail("should have thrown EmptyStackException");
		} catch (final IllegalArgumentException e) {
			System.out.println(e);
		}
	}
	@Test
	public void testArgument() {

		try {
			String[] str ={"GATI"};
			assertNotNull(ArgumentCheckUtil.notEmpty(str, "testArgument"));
		} catch (final IllegalArgumentException e) {
			fail("should have thrown EmptyStackException");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testListArgument() {
		List<String> list=null;
		try {
			list =new ArrayList<String>();
			assertNotNull(ArgumentCheckUtil.notEmpty(list, "listArgument"));
		} catch (final IllegalArgumentException e) {
			System.out.println(e);
		}
		list.add("gati");
		list=(List<String>) ArgumentCheckUtil.notEmpty(list, "listArgument");
	}

}

package com.gati.common.collection;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinarySearchTree {

	@Test
	public void should_test_empty_binarySearchTree() {
		BinarySearchTree<String> searchTree = new BinarySearchTree<String>();
		assertEquals(0, searchTree.getSize());
		assertEquals(true, searchTree.add("gati1"));
		assertEquals(1, searchTree.getSize());
		assertEquals(true, searchTree.add("gati1"));
		assertEquals(true, searchTree.add("gati1"));
		assertEquals(true, searchTree.add("gati1"));
		
	}
	
	@Test
	public void should_test_getcount_api() {
		BinarySearchTree<String> searchTree = new BinarySearchTree<String>();
		assertEquals(0, searchTree.getSize());
		assertEquals(true, searchTree.add("gati1"));
		assertEquals(1, searchTree.getSize());
		assertEquals(1, searchTree.getCount("gati1"));
		searchTree.add("gati1");
		searchTree.add("gati1");
		searchTree.add("gati1");
		assertEquals(4, searchTree.getCount("gati1"));
		searchTree.add("gati2");
		searchTree.add("gati2");
		searchTree.add("gati2");
		assertEquals(3, searchTree.getCount("gati2"));
		
	}

}

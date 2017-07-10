/**
 * 
 */
package com.gati.common.collection;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author sahug
 *
 */
public class BinarySearchTree<V> {
	private TreeNode<V> root;
	private int size;
	private Comparator<? super V> comparator;

	public BinarySearchTree() {
	}

	/**
	 * Returns the number of occurrences (cardinality) of the given object
	 * currently in the bag. If the object does not exist in the bag, return 0.
	 * 
	 * @param object
	 *            the object to search for
	 * @return the number of occurrences of the object, zero if not found
	 */
	public int getCount(V value) {
		TreeNode<V> localRoot = root;
		TreeNode<V> node = search(localRoot, value);
		if (value != null) {
			return node.getCount();
		}
		return -1;
	}

	public boolean search(V value) {
		TreeNode<V> localRoot = root;
		TreeNode<V> node = search(localRoot, value);
		if (node != null) {
			return true;
		}
		return false;
	}

	private TreeNode<V> search(TreeNode<V> root, V value) {
		int cmp;
		while (root != null) {
			cmp = getCompareValue(value, root.getValue());
			if (cmp == 0) {
				return root;
			} else if (cmp < 0) {
				root = root.getLeftChield();
			} else {
				root = root.getRightChield();
			}
		}

		return null;

	}

	private int getCompareValue(V value1, V value2) {
		int cmp;
		if (comparator != null) {
			cmp = comparator.compare(value1, value2);
		} else {
			Comparable<? super V> v = (Comparable<? super V>) value1;
			cmp = v.compareTo(value2);
		}
		return cmp;
	}

	public boolean add(V value) {
		return add(value, 1);

	}

	/**
	 * Adds <code>nCopies</code> copies of the specified object to the Bag.
	 * <p>
	 * If the object is already in the {@link #uniqueSet()} then increment its
	 * count as reported by {@link #getCount(Object)}. Otherwise add it to the
	 * {@link #uniqueSet()} and report its count as <code>nCopies</code>.
	 * 
	 * @param object
	 *            the object to add
	 * @param nCopies
	 *            the number of copies to add
	 * @return <code>true</code> if the object was not already in the
	 *         <code>uniqueSet</code>
	 */

	public boolean add(V value, int nCopies) {
		if (nCopies > 0) {
			TreeNode<V> localRoot = root;
			TreeNode<V> newNode = null;
			int cmp = 0;
			TreeNode<V> parent = null;
			if (localRoot == null) {
				newNode = new Node<V>(value, null);
				newNode.incrementBy(1);
				root = newNode;
				size++;
				return true;
			}
			while (localRoot != null) {
				parent = localRoot;
				cmp = getCompareValue(value, localRoot.getValue());
				if (cmp < 0) {
					localRoot = localRoot.getLeftChield();
				} else if (cmp > 0) {
					localRoot = localRoot.getRightChield();
				} else {
					localRoot.incrementBy(nCopies);
					return true;
				}
			}
			newNode = new Node<V>(value, parent);
			newNode.incrementBy(1);
			if (cmp < 0) {
				parent.setLeftChield(newNode);
			} else if (cmp > 0) {
				parent.setRightChield(newNode);
			}
			size++;
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	public Iterator<V> iterator() {
		return new Itr();
	}

	private class Itr<V> implements Iterator<V> {
		TreeNode<V> localNode = (TreeNode<V>) root;
		Stack<TreeNode<V>> stack;

		public Itr() {
			stack = new ArrayStack<TreeNode<V>>();
			stack.push(localNode);
			while (localNode != null) {
				stack.push(localNode);
				localNode = localNode.getLeftChield();
			}
		}

		public boolean hasNext() {
			return !stack.empty();
		}

		public V next() {
			TreeNode<V> node = stack.pop();
			V v = node.getValue();
			if (node.getRightChield() != null) {
				node = node.getRightChield();
				while (node != null) {
					stack.push(node);
					node = node.getLeftChield();
				}
			}
			return v;
		}

		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	static final class Node<V> implements TreeNode<V> {

		V value;
		int count;
		TreeNode<V> left;
		TreeNode<V> right;
		TreeNode<V> parent;

		public Node(V value, TreeNode<V> parent) {
			this.value = value;
			this.parent = parent;
		}

		public V getValue() {
			return value;
		}

		public TreeNode<V> getLeftChield() {
			return left;
		}

		public TreeNode<V> getRightChield() {
			return right;
		}

		public TreeNode<V> getParent() {
			return parent;
		}

		public void setLeftChield(TreeNode<V> leftNode) {
			left = leftNode;
		}

		public void setRightChield(TreeNode<V> rightNode) {
			right = rightNode;
		}

		public int getCount() {
			return count;
		}

		public void incrementBy(int noOfItems) {
			count = count + noOfItems;

		}

	}

}

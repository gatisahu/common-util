/**
 * 
 */
package com.gati.common.collection;

/**
 * @author sahug
 *
 */
public interface TreeNode<V> {

	public V getValue();

	public TreeNode<V> getLeftChield();

	public TreeNode<V> getRightChield();

	public void setLeftChield(TreeNode<V> treeNode);

	public void setRightChield(TreeNode<V> treeNode);

	public TreeNode<V> getParent();
	
	public void incrementBy(int noOfItems);
	
	public int getCount();

}

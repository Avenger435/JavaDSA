/**
 * 
 */
package com.java.dsa.faangmustdo;

import com.java.dsa.util.TreeNode;

/**
 * 
 */
public class MaxDepthBT {

	public static void main(String[] args) {

		Integer[] input2 = { 1, 2, 3, null, 5 };
		TreeNode binaryPathTree = TreeNode.createTreeFromArray(input2);
		TreeNode.printTree(binaryPathTree, "", false);

		int depth = getDepth(binaryPathTree);
		System.out.println("depth: " + depth);
		int maxDepth = getMaxDepthBT(binaryPathTree);
		System.out.println("max Depth: " + maxDepth);
	}

	public static int getMaxDepthBT(TreeNode node) {
		if (node == null)
			return 0;

		int leftDepth = getMaxDepthBT(node.left);
		int rightDepth = getMaxDepthBT(node.right);

		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static int getDepth(TreeNode node) {
		int maxDepth = 0;

		while (node != null) {
			node = node.left;
			maxDepth++;
		}

		return maxDepth;
	}

}

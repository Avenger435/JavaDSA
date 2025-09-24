package com.java.dsa.faangmustdo;

import com.java.dsa.util.TreeNode;

public class BTMaxPathSum {

	public static void main(String[] args) {

		// 1,2,3
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);

		TreeNode.printTree(root1, null, false);
		int maxPathSum1 = maxPathSum(root1);
		// -10,9,20,null,null,15,7
		TreeNode root2 = new TreeNode(-10);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(20);
		root2.right.left = new TreeNode(15);
		root2.right.right = new TreeNode(7);

		TreeNode.printTree(root2, null, false);
		int maxPathSum2 = maxPathSum(root2);
		System.out.println("maxPathSum1: " + maxPathSum1);
		System.out.println("maxPathSum2: " + maxPathSum2);
	}

	private static int maxSum;

	public static int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		helper(root);
		return maxSum;
	}

	private static int helper(TreeNode node) {
		// Base case: if the node is null, it contributes 0 to the path sum
		if (node == null)
			return 0;
		// recursively compute the max gain for left and right subtree.
		// if the gain is negative, treat it as 0 (ignore that subtree)
		int leftSum = Math.max(helper(node.left), 0);
		int rightSum = Math.max(helper(node.right), 0);

		// calculate the price of a new path where the current node is the highest node
		int priceNewPath = node.val + leftSum + rightSum;
		// update global max, if the new path is better.
		maxSum = Math.max(maxSum, priceNewPath);
		// return max gain the current node and one subtree can contribute to its
		// parent.
		return node.val + Math.max(leftSum, rightSum);
	}
}

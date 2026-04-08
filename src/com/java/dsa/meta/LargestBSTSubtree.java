package com.java.dsa.meta;

import com.java.dsa.util.TreeNode;

public class LargestBSTSubtree {

	private static class Result {
		boolean isBST;
		int size;
		int min;
		int max;

		Result(boolean isBST, int size, int min, int max) {
			this.isBST = isBST;
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}

	private int maxSize = 0;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);

		LargestBSTSubtree largestBSTSubtree = new LargestBSTSubtree();
		int result = largestBSTSubtree.largestBSTSubtree(root);
		System.out.println("Largest BST Subtree Size: " + result); // Output: 3

	}

	public int largestBSTSubtree(TreeNode root) {
		maxSize = 0;
		helper(root);
		return maxSize;
	}

	private Result helper(TreeNode node) {
		if (node == null) {
			return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Result left = helper(node.left);
		Result right = helper(node.right);

		if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
			int size = left.size + right.size + 1;
			maxSize = Math.max(maxSize, size);
			int minVal = Math.min(left.min, node.val);
			int maxVal = Math.max(right.max, node.val);
			return new Result(true, size, minVal, maxVal);
		} else {
			maxSize = Math.max(maxSize, Math.max(left.size, right.size));
			return new Result(false, 0, 0, 0);
		}
	}

}
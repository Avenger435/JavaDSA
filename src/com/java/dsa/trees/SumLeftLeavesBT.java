package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class SumLeftLeavesBT {

	public static void main(String[] args) {
		// Example tree:
		// 3
		// / \
		// 9 20
		// / \
		// 15 7
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		SumLeftLeavesBT solver = new SumLeftLeavesBT();
		int sum = solver.sumOfLeftLeaves(root);
		System.out.println("Sum of left leaves: " + sum); // Expected: 24 (9 + 15)

	}

	public int sumOfLeftLeaves(TreeNode root) {

		if (root == null)
			return 0;

		int sum = 0;
		//check if left child exits
		if (root.left != null) {
			// if left child is a leaf, add its value to the sum.
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			} else {
				//otherwise, recurse on the left child.
				sum += sumOfLeftLeaves(root.left);
			}

		}
		//Always recurse on the right child.
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}

}

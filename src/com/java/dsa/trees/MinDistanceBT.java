package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class MinDistanceBT {

	public static void main(String[] args) {
		// Create a sample binary tree:
		//        4
		//      /   \
		//     2     6
		//    / \
		//   1   3
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
		// Call the function to find the minimum difference in the binary tree
		int ans = minDiffInBT(root);
		// Print the result
		System.out.println(ans);
		
		int ansItr= minDiffInBTIterative(root);
		System.out.println(ansItr);
	}

	// Variable to store the minimum difference found so far
	private static int ans = Integer.MAX_VALUE;
	// Variable to store the value of the previous node in in-order traversal
	private static Integer pred = null;

	// Function to find the minimum difference between any two nodes in the binary tree
	private static int minDiffInBT(TreeNode root) {
		// Perform in-order traversal to compute minimum difference
		inoder(root);
		return ans;
	}

	// Helper function for in-order traversal
	private static void inoder(TreeNode root) {
		// Base case: if the node is null, return
		if (root == null)
			return;

		// Traverse the left subtree
		inoder(root.left);
		// If there is a predecessor, update the minimum difference
		if (pred != null) {
			ans = Math.min(ans, root.val - pred);
		}
		// Update the predecessor to the current node's value
		pred = root.val;
		// Traverse the right subtree
		inoder(root.right);
	}

	// Iterative solution to find the minimum difference between any two nodes in the binary tree
	private static int minDiffInBTIterative(TreeNode root) {
		// Stack for in-order traversal
		java.util.Stack<TreeNode> stack = new java.util.Stack<>();
		TreeNode curr = root;
		Integer pred = null;
		int minDiff = Integer.MAX_VALUE;

		// Iterate until all nodes are processed
		while (curr != null || !stack.isEmpty()) {
			// Go to the leftmost node
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			// Process the node
			curr = stack.pop();
			if (pred != null) {
				minDiff = Math.min(minDiff, curr.val - pred);
			}
			pred = curr.val;
			// Move to the right subtree
			curr = curr.right;
		}
		return minDiff;
	}

}
package com.java.dsa.faangmustdo;

import java.util.ArrayDeque;
import java.util.Deque;

import com.java.dsa.util.TreeNode;

/**
 * https://leetcode.com/problems/same-tree
 */
public class BTValidate {

	public static void main(String[] args) {

		// Test case 1: Valid BST [2,1,3]
		TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		boolean valid = isValidBST(root);
		System.out.println("IsValid: " + valid); // Expected: true
		System.out.println("isValidBSTRec: " + isValidBSTRec(root));

		// Test case 2: Invalid BST [5,-1,null]
		TreeNode root1 = new TreeNode(5, new TreeNode(-1), null);
		boolean valid1 = isValidBST(root1);
		System.out.println("IsValid: " + valid1); // Expected: true
		System.out.println("isValidBSTRec: " + isValidBSTRec(root1));

		// Test case 3: Invalid BST [5,1,4,null,null,3,6]
		TreeNode root2 = new TreeNode(5, new TreeNode(1, null, null),
				new TreeNode(4, new TreeNode(3), new TreeNode(6)));
		boolean valid2 = isValidBST(root2);
		System.out.println("IsValid: " + valid2); // Expected: false
		System.out.println("isValidBSTRec: " + isValidBSTRec(root2));

	}

	private static boolean isValidBSTRec(TreeNode root) {
		return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
		if (node == null)
			return true;
		if (node.val <= min || node.val >= max) {
			return false;
		}
		return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
	}

	/**
	 * Iteratively validates if a binary tree is a valid BST using in-order
	 * traversal. Each node's value must be greater than the previous node's value.
	 * 
	 * @param root The root of the binary tree
	 * @return true if the tree is a valid BST, false otherwise
	 */
	private static boolean isValidBST(TreeNode root) {

		Deque<TreeNode> stack = new ArrayDeque<>(); // Stack for in-order traversal

		TreeNode curr = root;
		long prev = Long.MIN_VALUE; // Store the value of the previous node

		while (curr != null || !stack.isEmpty()) {
			// Traverse to the leftmost node
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			// If the current node's value is not greater than the previous, it's not a BST
			if (curr.val <= prev)
				return false;
			prev = curr.val;
			// Move to the right subtree
			curr = curr.right;
		}
		return true;
	}

}
package com.java.dsa.faangmustdo;

import java.util.Stack;

import com.java.dsa.util.TreeNode;

public class BTKthSmallest {

	public static void main(String[] args) {

		// [3,1,4,null,2],
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		TreeNode.printTree(root, null, false);
		int k = 1;

		System.out.println(kthSmallest(root, k));

	}

	public static int kthSmallestItr(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			k--;
			if (k == 0)
				return curr.val;
			curr = curr.right;
		}
		return -1;
	}

	/**
	 * Finds the k-th smallest value in a BST using in-order traversal.
	 * 
	 * @param root The root of the BST.
	 * @param k    The k-th position to find (1-based).
	 * @return The k-th smallest value in the BST.
	 */
	public static int kthSmallest(TreeNode root, int k) {
		int[] count = { 0 };
		int[] result = { 0 };
		inorder(root, k, count, result);
		return result[0];
	}

	/**
	 * Performs in-order traversal to find the k-th smallest value. Increments count
	 * as nodes are visited in sorted order. When count reaches k, stores the node's
	 * value in result.
	 * 
	 * @param root   The current node.
	 * @param k      The k-th position to find.
	 * @param count  Array holding the current count of visited nodes.
	 * @param result Array to store the k-th smallest value when found.
	 */
	private static void inorder(TreeNode root, int k, int[] count, int[] result) {

		if (root == null)
			return;

		inorder(root.left, k, count, result);
		count[0]++;
		if (count[0] == k) {
			result[0] = root.val;
			return;
		}
		inorder(root.right, k, count, result);

	}

}
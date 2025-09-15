package com.java.dsa.trees;

import java.util.ArrayDeque; // Importing ArrayDeque for stack implementation
import java.util.ArrayList; // Importing ArrayList for result storage
import java.util.Collections; // Importing Collections for reversing the result
import java.util.Deque; // Importing Deque interface for stack
import java.util.List; // Importing List interface for result

import com.java.dsa.util.TreeNode; // Importing TreeNode class

public class BTPostorderTraversal {

	public static void main(String[] args) {
		// Main method for testing purposes (currently empty)
	}

	// Iterative post order traversal using a stack
	public List<Integer> postorderTraversalIterative(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>(); // List to store the result

		if (root == null)
			return result; // Return empty list if root is null

		Deque<TreeNode> stack = new ArrayDeque<>(); // Stack to help with traversal
		stack.push(root); // Push root node onto the stack

		while (!stack.isEmpty()) { // Loop until stack is empty
			root = stack.pop(); // Pop the top node from the stack
			result.add(root.val); // Add the node's value to the result

			if (root.left != null) {
				stack.push(root.left); // Push left child if it exists
			}
			if (root.right != null) {
				stack.push(root.right); // Push right child if it exists
			}

		}
		Collections.reverse(result); // Reverse the result to get postorder
		return result; // Return the postorder traversal

	}

	// Recursive post order traversal
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>(); // List to store the result
		postOrder(root, result); // Helper method to fill the result
		return result; // Return the postorder traversal
	}

	// Helper method for recursive post order traversal
	private void postOrder(TreeNode root, List<Integer> result) {
		if (root == null)
			return; // Base case: if node is null, do nothing

		postOrder(root.left, result); // Traverse left subtree
		postOrder(root.right, result); // Traverse right subtree
		result.add(root.val); // Add the node's value to the result

	}

}
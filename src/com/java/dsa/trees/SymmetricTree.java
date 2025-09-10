package com.java.dsa.trees;

/*
LeetCode Pattern: Breadth-First Search (BFS) and Two Pointers (Mirror Traversal)

This problem is commonly categorized under the BFS pattern for the iterative approach (using a queue to traverse the tree level by level in mirrored pairs),
 and the Two Pointers/Recursion pattern for the recursive approach (comparing left and right subtrees in a mirrored fashion).
*/

import com.java.dsa.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	public static void main(String[] args) {
		// Example usage:
		// TreeNode root = ... // build your tree
		// System.out.println(new SymmetricTree().isSymmetricIterative(root));
	}

	// Recursive solution to check if a tree is symmetric
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root, root); // Compare the tree with itself
	}

	// Helper method for recursive symmetry check
	private boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null || q == null) // If either node is null
			return p == q; // Both must be null to be symmetric
		// Check current node values and recurse on children in mirrored order
		return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
	}

	// Optimized iterative solution to check if a tree is symmetric
	public boolean isSymmetricIterative(TreeNode root) {
		if (root == null)
			return true; // An empty tree is symmetric
		Queue<TreeNode> queue = new LinkedList<>(); // Queue for BFS
		queue.add(root.left); // Add left child
		queue.add(root.right); // Add right child
		while (!queue.isEmpty()) {
			TreeNode left = queue.poll(); // Get next left node
			TreeNode right = queue.poll(); // Get next right node
			if (left == null && right == null)
				continue; // Both null, symmetric at this node
			if (left == null || right == null)
				return false; // Only one is null, not symmetric
			if (left.val != right.val)
				return false; // Values differ, not symmetric
			// Add children in mirrored order
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true; // All checks passed, tree is symmetric
	}
}
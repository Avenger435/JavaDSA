package com.java.dsa.trees; // Package declaration

import java.util.ArrayList; // Import ArrayList
import java.util.LinkedList; // Import LinkedList
import java.util.List; // Import List
import java.util.Queue; // Import Queue

import com.java.dsa.util.TreeNode; // Import TreeNode class

public class TZigZagLevelOrder { // Class definition

	public static void main(String[] args) { // Main method
		TreeNode root = new TreeNode(1); // Create root node with value 1
		root.left = new TreeNode(2); // Add left child with value 2
		root.left.left = new TreeNode(4); // Add left child to node 2 with value 4
		root.right = new TreeNode(7); // Add right child with value 7
		root.right.right = new TreeNode(8); // Add right child to node 7 with value 8
		TreeNode.printTree(root, null, false); // Print the tree structure
		System.out.println(); // Print a new line

		List<List<Integer>> zigZagLevelOrderTraversal = zigzagLevelOrder(root); // Call zigzagLevelOrder and store result

		System.out.println("zigZagLevelOrderTraversal: " + zigZagLevelOrderTraversal); // Print the result

	}

	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) { // Method to perform zigzag level order traversal
		List<List<Integer>> result = new ArrayList<>(); // List to store the final result
		if (root == null)
			return result; // Return empty list if root is null

		Queue<TreeNode> queue = new LinkedList<>(); // Queue for level order traversal

		queue.offer(root); // Add root to the queue
		boolean leftToRight = true; // Flag to control zigzag direction

		while (!queue.isEmpty()) { // Loop until queue is empty
			int size = queue.size(); // Number of nodes at current level

			LinkedList<Integer> level = new LinkedList<>(); // List to store current level values

			for (int i = 0; i < size; i++) { // Iterate over all nodes at current level
				TreeNode node = queue.poll(); // Remove node from queue
				if (leftToRight)
					level.addLast(node.val); // Add value to the end if left to right
				else
					level.addFirst(node.val); // Add value to the front if right to left

				if (node.left != null)
					queue.offer(node.left); // Add left child to queue if exists
				if (node.right != null)
					queue.offer(node.right); // Add right child to queue if exists
			}

			result.add(level); // Add current level to result
			leftToRight = !leftToRight; // Toggle direction for next level
		}

		return result; // Return the zigzag level order traversal
	}

}
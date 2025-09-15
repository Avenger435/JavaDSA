package com.java.dsa.trees; // Package declaration

import java.util.ArrayList; // Import ArrayList for dynamic array
import java.util.Arrays; // Import Arrays utility class
import java.util.HashMap; // Import HashMap for frequency counting
import java.util.List; // Import List interface
import java.util.Map; // Import Map interface

import com.java.dsa.util.TreeNode; // Import TreeNode class

public class BTMode { // Class to find mode(s) in a binary tree

	public static void main(String[] args) { // Main method
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null)); // Create a sample binary tree
		TreeNode.printTree(root, null, false); // Print the tree structure
		
		BTMode btMode= new BTMode(); // Create an instance of BTMode
		int[] mode = btMode.findModeSimple(root); // Find mode(s) in the tree
		System.out.println("mode: "+ Arrays.toString(mode)); // Print the mode(s)
	}

	public int[] findMode(TreeNode root) { // Simpler method to find mode(s) in the tree
		if (root == null) return new int[0]; // Handle empty tree

		Map<Integer, Integer> freq = new HashMap<>(); // Map to store value frequencies
		traverseAndCount(root, freq); // Traverse tree and count frequencies

		int maxFreq = 0; // Track maximum frequency
		for (int count : freq.values()) {
			if (count > maxFreq) maxFreq = count;
		}

		List<Integer> modes = new ArrayList<>(); // List to store mode(s)
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() == maxFreq) {
				modes.add(entry.getKey());
			}
		}

		return modes.stream().mapToInt(Integer::intValue).toArray(); // Convert list to array and return
	}

	private void traverseAndCount(TreeNode node, Map<Integer, Integer> freq) { // Helper to traverse and count frequencies
		if (node == null) return;
		freq.put(node.val, freq.getOrDefault(node.val, 0) + 1); // Increment frequency
		traverseAndCount(node.left, freq); // Traverse left
		traverseAndCount(node.right, freq); // Traverse right
	}

	// Simpler solution using HashMap for any binary tree
	public int[] findModeSimple(TreeNode root) {
		if (root == null) return new int[0]; // Handle empty tree

		Map<Integer, Integer> freq = new HashMap<>(); // Map to store value frequencies
		traverseAndCountSimple(root, freq); // Traverse tree and count frequencies

		int maxFreq = 0; // Track maximum frequency
		for (int count : freq.values()) {
			if (count > maxFreq) maxFreq = count;
		}

		List<Integer> modes = new ArrayList<>(); // List to store mode(s)
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() == maxFreq) {
				modes.add(entry.getKey());
			}
		}

		return modes.stream().mapToInt(Integer::intValue).toArray(); // Convert list to array and return
	}

	private void traverseAndCountSimple(TreeNode node, Map<Integer, Integer> freq) {
		if (node == null) return;
		freq.put(node.val, freq.getOrDefault(node.val, 0) + 1); // Increment frequency
		traverseAndCountSimple(node.left, freq); // Traverse left
		traverseAndCountSimple(node.right, freq); // Traverse right
	}

	// MappedByteBuffer (unused)

}
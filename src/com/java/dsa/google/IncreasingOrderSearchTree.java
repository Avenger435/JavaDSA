package com.java.dsa.google; // Package declaration for the Google DSA problems

public class IncreasingOrderSearchTree { // Class definition for the Increasing Order Search Tree problem

	public static void main(String[] args) { // Main method to test the functionality

		TreeNode root = new TreeNode(5); // Create the root node with value 5
		root.left = new TreeNode(3); // Set left child of root to 3
		root.right = new TreeNode(6); // Set right child of root to 6
		root.left.left = new TreeNode(2); // Set left-left grandchild to 2
		root.left.right = new TreeNode(4); // Set left-right grandchild to 4
		root.right.right = new TreeNode(8); // Set right-right grandchild to 8
		root.left.left.left = new TreeNode(1); // Set left-left-left great-grandchild to 1
		root.right.right.left = new TreeNode(7); // Set right-right-left great-grandchild to 7
		root.right.right.right = new TreeNode(9); // Set right-right-right great-grandchild to 9

		IncreasingOrderSearchTree iosTree = new IncreasingOrderSearchTree(); // Instantiate the class
		TreeNode result = iosTree.increasingBST(root); // Call the method to transform the tree

		printTree(result); // Print the resulting tree // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
	}

	private static void printTree(TreeNode result) { // Method to print the tree in order
		TreeNode current = result; // Start from the result node
		while (current != null) { // Loop until the end of the list
			System.out.print(current.val + " "); // Print the current node's value
			current = current.right; // Move to the next node
		}
		System.out.println(); // Print a newline
	}

	public TreeNode increasingBST(TreeNode root) { // Method to transform BST to increasing order
		if (root == null) // If root is null
			return null; // Return null

		TreeNode dummyNode = new TreeNode(-1); // Create a dummy node
		TreeNode currentNode = dummyNode; // Set current node to dummy

		inOrderTraversal(root, currentNode); // Perform in-order traversal
		return dummyNode.right; // Return the right of dummy (start of list)
	}

	private TreeNode inOrderTraversal(TreeNode node, TreeNode currentNode) { // Helper method for in-order traversal
		if (node == null) // If node is null
			return currentNode; // Return current node

		currentNode = inOrderTraversal(node.left, currentNode); // Recurse on left subtree
		System.out.println("Visiting node: " + node.val); // Debug statement to show visiting node
		currentNode.right = node; // Set current's right to node
		node.left = null; // Set node's left to null
		currentNode = node; // Update current to node
		System.out.println("Current node updated to: " + currentNode.val); // Debug statement to show current node update
		currentNode = inOrderTraversal(node.right, currentNode); // Recurse on right subtree
		return currentNode; // Return current node
	}

}
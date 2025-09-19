package com.java.dsa.trees; // Package declaration

import com.java.dsa.util.TreeNode; // Import TreeNode class

public class TMorrisInorder { // Class definition

	public static void main(String[] args) { // Main method

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(8);
		TreeNode.printTree(root, null, false);
		System.out.println();
		morrisInorder(root);

	}

	public static void morrisInorder(TreeNode root) { // Method to perform Morris Inorder Traversal
		// pointer
		TreeNode current = root; // Initialize current node as root

		while (current != null) { // Loop until all nodes are traversed
			if (current.left == null) { // If there is no left child
				System.out.print(current.val + " "); // Print current node's value
				current = current.right; // Move to right child
			} else { // If left child exists
				TreeNode predecessor = current.left; // Find the inorder predecessor (rightmost node in left subtree)
				while (predecessor.right != null && predecessor.right != current) { // Find the rightmost node or a
																					// thread pointing to current
					predecessor = predecessor.right; // Move to right child
				}

				if (predecessor.right == null) { // If thread does not exist
					predecessor.right = current; // Create a thread to the current node
					current = current.left; // Move to left child
				} else { // If thread already exists
					predecessor.right = null; // Remove the thread
					System.out.print(current.val + " "); // Print current node's value
					current = current.right; // Move to right child
				}
			}
		}
	}
}
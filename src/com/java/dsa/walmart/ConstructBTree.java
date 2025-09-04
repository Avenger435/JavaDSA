
// Package declaration
package com.java.dsa.walmart;


// Import TreeNode utility class
import com.java.dsa.util.TreeNode;


// Main class to construct binary tree from traversals
public class ConstructBTree {
    public static void main(String[] args) {
        // Example input array for tree construction (level order, null for missing nodes)
        Integer[] input2 = { 3, 9, 20, null, null, 15, 7 };
        // Create a binary tree from the array
        TreeNode binaryPathTree = TreeNode.createTreeFromArray(input2);
        // Print the tree (commented out)
        // TreeNode.printTree(binaryPathTree, "", false);
        // Print inorder traversal (commented out)
        // System.out.println("inOrder: ");
        // TreeNode.inOrder(binaryPathTree);
        // System.out.println();
        // Print preorder traversal (commented out)
        // System.out.println("PreOrder");
        // Print preorder traversal of the tree
        TreeNode.preOrder(binaryPathTree);
        // Example inorder and postorder arrays for reconstruction
        int[] inOrder = { 9, 3, 15, 20, 7 };
        int[] postOrder = { 9, 15, 7, 20, 3 };

        // Build tree from inorder and postorder traversals
        TreeNode root = buildTree(inOrder, postOrder);
        // Print the reconstructed tree
        TreeNode.printTree(root, null, false);

    }


    // Public method to build tree from inorder and postorder arrays
    public static TreeNode buildTree(int[] inorder, int[] postOrder) {
        // Call helper with full array bounds
        return build(postOrder, 0, postOrder.length - 1, inorder, 0, inorder.length - 1);
    }


    // Helper method to recursively build the tree
    public static TreeNode build(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd){
        // Base case: if bounds are invalid, return null
        if(postStart > postEnd || inStart > inEnd) return null;

        // The last element in postOrder is the root value
        int rootVal = postOrder[postEnd];
        // Create the root node
        TreeNode root = new TreeNode(rootVal);
        // Find the index of root value in inorder array
        int inRoot = inStart;
        while(inRoot <= inEnd && inOrder[inRoot] != rootVal) inRoot++;
        // Number of nodes in the left subtree
        int leftTreeSize = inRoot - inStart;
        // Recursively build the left subtree
        root.left = build(postOrder, postStart, postStart + leftTreeSize - 1, inOrder, inStart, inRoot - 1);
        // Recursively build the right subtree
        root.right = build(postOrder, postStart + leftTreeSize, postEnd - 1, inOrder, inRoot + 1, inEnd);
        // Return the constructed root
        return root;

    }

}

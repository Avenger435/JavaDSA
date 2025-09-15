package com.java.dsa.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.java.dsa.util.TreeNode;

public class BTInorderTraversal {

	
	
	  // Recursive inorder traversal
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inoder(root, result);
        return result;
    }

    private void inoder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inoder(node.left, result);
        result.add(node.val);
        inoder(node.right, result);
    }
	
    // Iterative inorder traversal using a stack
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

  

   
}
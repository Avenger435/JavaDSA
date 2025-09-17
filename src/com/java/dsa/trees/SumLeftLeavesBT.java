package com.java.dsa.trees;

import java.util.ArrayDeque;
import java.util.Deque;

import com.java.dsa.util.TreeNode;

public class SumLeftLeavesBT {

	public static void main(String[] args) {
		// Example tree:
		// 3
		// / \
		// 9 20
		// / \
		// 15 7
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		SumLeftLeavesBT solver = new SumLeftLeavesBT();
		int sum = solver.sumOfLeftLeaves(root);
		System.out.println("Sum of left leaves: " + sum); // Expected: 24 (9 + 15)

	}

	public int sumOfLeftLeaves(TreeNode root) {

		if (root == null)
			return 0;

		int sum = 0;
		//check if left child exits
		if (root.left != null) {
			// if left child is a leaf, add its value to the sum.
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
			} else {
				//otherwise, recurse on the left child.
				sum += sumOfLeftLeaves(root.left);
			}

		}
		//Always recurse on the right child.
		sum += sumOfLeftLeaves(root.right);
		return sum;
	}

	/*
	 * Iteratively traverse to the leaf nodes using DFS
	 */
	public int sumOfLeftLeavesIterative(TreeNode root) {
		
		if(root==null)
			return 0;
		//Leaves, so we go depth first, thus use a stack.
		Deque<TreeNode> stack= new ArrayDeque<>();
		int sum=0;
		//Add root to the stack.
		stack.push(root);
		
		//edge case.
		while(!stack.isEmpty()) {
			//take the value from the stack for processing.
			TreeNode node= stack.pop();
			//check if left is not null.
			if(node.left!=null) {
				//if both left's left and left's right are empty, we are at a leaf node.
				if(node.left.left==null && node.left.right==null) {
					//add node.left.val to the sum.
					sum+=node.left.val;
				}else {
					// we still have child nodes
					//push the current node to the stack and continue.
					stack.push(node.left);
				}
			}
			//similarly check if node has a right tree, push it on stack to process.
			if(node.right!=null) {
				stack.push(node.right);
			}
			
		}
	
		return sum;
	}
	
	
}

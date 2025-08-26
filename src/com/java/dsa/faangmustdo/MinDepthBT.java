/**
 * 
 */
package com.java.dsa.faangmustdo;

import java.util.LinkedList;
import java.util.Queue;

import com.java.dsa.util.TreeNode;

/**
 * 
 */
public class MinDepthBT {

	public static int minimum = Integer.MAX_VALUE;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		Integer[] input2 = { 1, 2, 3, null, 5 };
//		TreeNode binaryPathTree = TreeNode.createTreeFromArray(input2);
//		TreeNode.printTree(binaryPathTree, "", false);

//		int minDepth2 = minDepth(binaryPathTree);
//		System.out.println("min Depth: " + minDepth2);

		Integer[] input1 = { 2, null, 3, null, 4, null, 5, null, 6 };
		TreeNode binaryTree1 = TreeNode.createTreeFromArray(input1);
		TreeNode.printTree(binaryTree1, "", false);

		int minDepth1 = minDepth(binaryTree1);
		System.out.println("min Depth: 1: " + minDepth1);

		int minDepthBFS = minDepthBFS(binaryTree1);
		System.out.println("minDepthBFS: " + minDepthBFS);

		// use optimized

		int minDepthLeaf = minDepthLeaf(binaryTree1);

		System.out.println("minDepthLeaf: " + minDepthLeaf);

	}

	public static int minDepthLeaf(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root, 0);
		return minimum;
	}

	public static void dfs(TreeNode root, int depth) {
		depth++;

		if (minimum == depth)
			return;
		if (isLeaf(root)) {
			minimum = Math.min(minimum, depth);
			return;
		}

		if (root.right != null && (root.left == null || !isLeaf(root.left)))
			dfs(root.right, depth);

		if (root.left != null)
			dfs(root.left, depth);

	}

	public static boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public static int minDepthBFS(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int depth = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				// check if the node is leaf, early exit.
				if (node.left == null && node.right == null)
					return depth;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			depth++;
		}

		return depth;
	}

	public static int minDepth(TreeNode root) {

		// edge case
		if (root == null)
			return 0;

		// if one child is null, we must go through other child
		if (root.left == null)
			return 1 + minDepth(root.right);
		if (root.right == null)
			return 1 + minDepth(root.left);

		// if both child exist we take minimum of the both
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}

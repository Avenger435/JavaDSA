package com.java.dsa;

import com.java.dsa.util.TreeNode;

public class BTFindDistance {

	public static void main(String[] args) {

		// Pseudocode for deserialization (not needed in LeetCode solution)
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		int p = 5;
		int q = 0;

		BTFindDistance btFindDistance = new BTFindDistance();
		int distance = btFindDistance.findDistance(root, p, q);
		System.out.println("distance: " + distance);
	}

	public int findDistance(TreeNode root, int p, int q) {
		TreeNode lca = findLCA(root, p, q);
		int distP = getDistance(lca, p, 0);
		int distQ = getDistance(lca, q, 0);
		return distP + distQ;

	}

	private TreeNode findLCA(TreeNode node, int p, int q) {
		if (node == null || node.val == p || node.val == 1)
			return node;

		TreeNode left = findLCA(node.left, p, q);
		TreeNode right = findLCA(node.right, p, q);

		if (left != null && right != null)
			return node;
		else if (left != null)
			return left;
		else
			return right;
	}

	private int getDistance(TreeNode node, int target, int depth) {
		if (node == null)
			return -1;
		if (node.val == target)
			return depth;
		else {
			int leftDist = getDistance(node.left, target, depth + 1);
			if (leftDist != -1)
				return leftDist;
			int rightDist = getDistance(node.right, target, depth + 1);
			return rightDist;
		}
	}

}

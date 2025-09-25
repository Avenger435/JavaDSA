package com.java.dsa.blind75;

import com.java.dsa.util.TreeNode;

public class BTLeastCommonAncestor {

	public static void main(String[] args) {

		// 6,2,8,0,4,7,9,null,null,3,5
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		TreeNode.printTree(root, null, false);

		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);
		TreeNode lowestCommonAncestor = lowestCommonAncestor(root, p, q);
		TreeNode.printTree(lowestCommonAncestor, null, false);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;

		TreeNode curr = root;
		if (curr == p || curr == q)
			return curr;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;

	}

	public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;

		TreeNode curr = root;
		if (curr == p || curr == q) {
			return curr;
		}

		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}
}

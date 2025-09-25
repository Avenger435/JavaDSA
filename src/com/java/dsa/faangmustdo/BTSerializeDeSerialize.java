package com.java.dsa.faangmustdo;

import java.util.ArrayDeque;
import java.util.Queue;

import com.java.dsa.util.TreeNode;

public class BTSerializeDeSerialize {

	public static void main(String[] args) {

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

		String serialize = serialize(root);
		System.out.println(serialize);
		TreeNode ans = deserialize(serialize);
		TreeNode.printTree(ans, serialize, false);
	}

	public static String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private static void serialize(TreeNode root, StringBuilder sb) {
		if (root == null)
			return;
		sb.append(root.val).append(" ");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	
	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if (data.isEmpty())
			return null;

		final String[] vals = data.split(" ");
		Queue<Integer> q = new ArrayDeque<>();

		for (final String val : vals)
			q.offer(Integer.parseInt(val));

		return deserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
	}

	

	private static TreeNode deserialize(int mn, int mx, Queue<Integer> q) {
		if (q.isEmpty())
			return null;

		final int val = q.peek();
		if (val < mn || val > mx)
			return null;

		q.poll();
		TreeNode root = new TreeNode(val);
		root.left = deserialize(mn, val, q);
		root.right = deserialize(val, mx, q);
		return root;
	}
}
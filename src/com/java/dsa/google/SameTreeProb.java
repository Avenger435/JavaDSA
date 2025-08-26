/**
 * 
 */
package com.java.dsa.google;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/same-tree/description/
 * 
 */
public class SameTreeProb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(1 << 2);

//		Integer[] input = { 1, 1, 1, 2, 3 };
//		TreeNode tree1 = createTreeFromArray(input);
//		TreeNode tree2 = createTreeFromArray(input);
//		printTree(tree1, "", false);
//		System.out.println("isSameTree: " + isSameTree(tree1, tree2));
//		Integer[] input1 = { 1, 2, 3, 4, 5, 6 };
//		TreeNode countTree = createTreeFromArray(input1);
//		printTree(countTree, "", false);
//		int treeCount = countNodes(countTree);
//		System.out.println(treeCount);
		Integer[] input2 = { 1, 2, 3, null, 5 };
		TreeNode binaryPathTree = createTreeFromArray(input2);
		printTree(binaryPathTree, "", false);

		List<String> binaryTreePaths = binaryTreePaths(binaryPathTree);
		System.out.println("binaryTreePaths: " + binaryTreePaths);
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		if (root == null)
			return list;
		dfs(root, sb, list);
		return list;

	}

	/**
	 * @param node
	 */
	private static void dfs(TreeNode node, StringBuilder path, List<String> paths) {
		if (node == null)
			return;
		path.append(node.val);
		int len=path.length();
		if (node.left == null && node.right == null) {
			paths.add(path.toString());
		} else {
			path.append("->");
			dfs(node.left, path, paths);
			dfs(node.right, path, paths);
			path.setLength(len);
		}
		

	}

	public static int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);

		if (leftDepth == rightDepth) {
			// left subTree is perfect
			return (1 << leftDepth) + countNodes(root.right);
		} else {
			// right subtree is perfect
			return (1 << rightDepth) + countNodes(root.left);
		}

	}

	public static int getDepth(TreeNode node) {

		int depth = 0;
		while (node != null) {
			node = node.left;
			depth++;
		}

		return depth;
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}

	public static TreeNode createTreeFromArray(Integer[] arr) {
		if (arr == null || arr.length == 0 || arr[0] == null)
			return null;
		TreeNode root = new TreeNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int i = 1;
		while (i < arr.length) {
			TreeNode current = queue.poll();
			// left child;
			if (i < arr.length && arr[i] != null) {
				current.left = new TreeNode(arr[i]);
				queue.offer(current.left);
			}
			i++;
			// right child
			if (i < arr.length && arr[i] != null) {
				current.right = new TreeNode(arr[i]);
				queue.offer(current.right);
			}
			i++;
		}

		return root;
	}

	// in-order left root right
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.println(root.val + " ");
		inOrder(root.right);
	}

	// pre-order root left right
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	// pre-order left right root
	public static void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.val + " ");
	}

	public static void printTree(TreeNode root, String indent, boolean isLeft) {
		if (root == null)
			return;

		printTree(root.right, indent + (isLeft ? "│   " : "    "), false);
		System.out.println(indent + (isLeft ? "└── " : "┌── ") + root.val);
		printTree(root.left, indent + (isLeft ? "    " : "│   "), true);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {

	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}

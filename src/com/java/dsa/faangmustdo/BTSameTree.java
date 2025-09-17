package com.java.dsa.faangmustdo;

import java.util.LinkedList;
import java.util.Queue;

import com.java.dsa.util.TreeNode;

/**
 * https://leetcode.com/problems/same-tree
 */
public class BTSameTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null));
		System.out.println(isSameTree(root, root));

		System.out.println(isSameTreeItr(root, root));
	}

	private static boolean isSameTreeItr(TreeNode p, TreeNode q) {

		Queue<TreeNode> queueP = new LinkedList<>();
		Queue<TreeNode> queueQ = new LinkedList<>();

		queueP.add(p);
		queueQ.add(q);

		while (!queueP.isEmpty() && !queueQ.isEmpty()) {
			TreeNode nodeP = queueP.poll();
			TreeNode nodeQ = queueQ.poll();

			if (nodeP == null && nodeQ == null)
				continue;
			if (nodeP == null || nodeQ == null)
				return false;
			if (nodeP.val != nodeQ.val)
				return false;
			queueP.add(nodeP.left);
			queueQ.add(nodeQ.left);
			queueP.add(nodeP.right);
			queueQ.add(nodeQ.right);
		}

		return queueP.isEmpty() && queueQ.isEmpty();
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		// If both nodes are null, trees are identical at this branch
		if (p == null && q == null)
			return true;

		// If only one is null, trees are not identical
		if (p == null || q == null)
			return false;

		// If values differ, trees are not identical
		if (p.val != q.val)
			return false;

		// Recursively check left and right subtrees
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

	}

}
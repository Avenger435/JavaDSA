package com.java.dsa.faangmustdo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.java.dsa.util.TreeNode;

/**
 * 
 */
public class BTLevelOrderTraversal {

	public static void main(String[] args) {
		// [3,9,20,null,null,15,7]

		TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
				new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		List<List<Integer>> levelOrder = levelOrder(root);
		System.out.println(levelOrder);
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> level = new ArrayList<>();

			for (int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);

				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			result.add(level);
		}
		return result;
	}

}

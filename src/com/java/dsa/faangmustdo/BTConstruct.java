package com.java.dsa.faangmustdo;

import java.util.HashMap;
import java.util.Map;

import com.java.dsa.util.TreeNode;

public class BTConstruct {

	public static void main(String[] args) {

		int[] preorder = { 3, 9, 20, 15, 7 }; // CLR
		int[] inorder = { 9, 3, 15, 20, 7 }; // LCR

		TreeNode tree = buildTree(preorder, inorder);
		TreeNode.printTree(tree, null, false);
	}

	private static TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inMap.put(inorder[i], i);
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

	}

	private static TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
			Map<Integer, Integer> inMap) {

		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		// pre-order first value is always the root.
		int rootVal = preorder[preStart];
		TreeNode root = new TreeNode(rootVal);

		// find root in inorder
		int inRoot = inMap.get(rootVal);

		// check the size of left subtree.
		int leftSize = inRoot - inStart;
		// left starts from index 1 as 0 is the root and ends at preStart + leftSize of
		// inorder, similarly instart and inRoot -1 are bounds.
		root.left = helper(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inRoot - 1, inMap);
		root.right = helper(preorder, preStart + leftSize + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

		return root;
	}

}

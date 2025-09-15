package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class InvertBTree {

	public TreeNode invertTree(TreeNode root) {
		
		if(root==null)
			return null;
		TreeNode temp= root.left;
		root.left= invertTree(root.right);
		root.right= invertTree(temp);
		return root;
		
	}

	

}

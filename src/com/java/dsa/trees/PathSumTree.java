package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class PathSumTree {

	public static void main(String[] args) {
		
		Integer[] intArr= {5,4,8,11,null,13,4,7,2,null,null,null,1};
	
		TreeNode root= TreeNode.buildTreeFromArray(intArr);
		int target= 22;
		
		boolean hasPathSum = hasPathSum(root, target);
		System.out.println("hasPathSum: "+ hasPathSum);
		
		
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		
		if(root==null)
			return false;
		
		if(root.val==targetSum && root.left==null && root.right==null)
			return true;
		
		return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);

	}

}

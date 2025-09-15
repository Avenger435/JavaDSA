package com.java.dsa.trees;

import java.util.ArrayList;
import java.util.List;

import com.java.dsa.util.TreeNode;

public class BTPreorderTraversal {
	
	public static void main(String[] args) {
		Integer[] intArr= {1,null,2,3};
		TreeNode root= TreeNode.buildTreeFromArray(intArr);
		TreeNode.printTree(root, null, false);
		
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result= new ArrayList<>();
		preorder(root,result);
		return result;
		}

	private void preorder(TreeNode root, List<Integer> result) {
			
		if(root==null)
			return;
		
		result.add(root.val);
		preorder(root.left, result);
		preorder(root.right,result);
		
	}

}

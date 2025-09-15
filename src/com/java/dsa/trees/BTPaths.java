package com.java.dsa.trees;

import java.util.ArrayList;
import java.util.List;

import com.java.dsa.util.TreeNode;

public class BTPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public List<String> binaryTreePaths(TreeNode root){
		List<String> result= new ArrayList<>();
		StringBuilder path= new StringBuilder();
		dfs(root,path,result);
		return result;	
	}


	private void dfs(TreeNode root, StringBuilder path, List<String> paths) {
		int len=path.length();
		if(root==null)
			return;
		
		path.append(root.val);
		
		if(root.left==null && root.right==null) {
			paths.add(path.toString());
		}else {
			path.append("->");
			dfs(root.left,path,paths);
			dfs(root.right,path,paths);
		}
		path.setLength(len);
	}

}

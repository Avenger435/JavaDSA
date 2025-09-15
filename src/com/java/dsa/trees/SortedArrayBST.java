package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class SortedArrayBST {

	public static void main(String[] args) {


		TreeNode case1Output = sortedArrayToBST(new int[] {}) ;
		printInOrder(case1Output);
		
		TreeNode case2output = sortedArrayToBST(new int[] {-10,-3,0,5,9}) ;
		printInOrder(case2output);
		
		

	}

	
	  // Optional: In-order traversal to verify structure
    public  static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
    
	public static TreeNode sortedArrayToBST(int[] nums) {
		return buildBalancedTree(nums, 0, nums.length-1);
	}

	private static TreeNode buildBalancedTree(int[] nums, int start, int end) {

		if(start>end)
			return null;
		
		int mid= start +(end-start)/2;
		
		TreeNode root= new TreeNode(nums[mid]);
		root.left= buildBalancedTree(nums, start, mid-1);
		root.right= buildBalancedTree(nums, mid+1, end);		
		
		return root;
	}

}

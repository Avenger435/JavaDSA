package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class HeightBalancedBT {

	public static void main(String[] args) {

		
		HeightBalancedBT obj= new HeightBalancedBT();
		
		Integer[] intArr1 = { 3, 9, 20, null, null, 15, 7 };
		TreeNode tree1 = TreeNode.buildTreeFromArray(intArr1);
		System.out.println("IsBalanced case 1: " + obj.isBalanced(tree1));

		Integer[] intArr2 = { 1, 2, 2, 3, 3, null, null, 4, 4 };
		System.out.println("IsBalanced case 2:" + obj.isBalanced(TreeNode.buildTreeFromArray(intArr2)));

	}


	public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return ans;
    }

    private boolean ans = true;

    // Returns the height of root and sets ans to false if root unbalanced.
    public int maxDepth(TreeNode root) {
        if (root == null || !ans)
            return 0;
        final int left = maxDepth(root.left);
        final int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1)
            ans = false;
        return Math.max(left, right) + 1;
    }


	
	
	
	public static boolean isBalanced1(TreeNode root) {
		if (root == null)
			return true;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
	}

	private static int height(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));

	}

}
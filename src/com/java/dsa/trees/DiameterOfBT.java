package com.java.dsa.trees;

import com.java.dsa.util.TreeNode;

public class DiameterOfBT {
    private int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        
       //calling the max depth path 
       maxDepth(root);
       //return ans
       return ans;
    }
    /**
     * calculate left and right depth, keep ans updated, 
     * return 1+ max b/w l and r -> Add root.
     */
    public int maxDepth(TreeNode root){
        if(root==null)
        return 0;
        // calculate left depth
        final int l= maxDepth(root.left);
        // calculate right depth
        final int r= maxDepth(root.right);
        //keep max updated.
        ans= Math.max(ans, l+r);
        //return depth
        return 1+ Math.max(l,r);
   }}

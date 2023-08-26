package com.zdy.leetcode.algorithm.top100.binarytree;

/**
 * 翻转二叉树：https://leetcode.cn/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left!=null){
            invertTree(left);
        }
        if(right!=null){
            invertTree(right);
        }
        swap(root);
        return root;
    }

    public void swap(TreeNode root){
        if(root.left==null && root.right==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}

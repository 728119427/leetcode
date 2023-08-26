package com.zdy.leetcode.algorithm.top100.binarytree;

/**
 * 二叉树的直径：https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一棵二叉树的根节点，返回该树的 直径
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterOfBinaryTree {

    private int ans =1;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return ans-1;
    }

    private int getDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        ans = Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
}

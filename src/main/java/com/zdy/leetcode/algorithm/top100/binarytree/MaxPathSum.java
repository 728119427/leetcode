package com.zdy.leetcode.algorithm.top100.binarytree;

/**
 * 二叉树中的最大路径和：https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked
 *
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class MaxPathSum {

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        getMaxPathSum(root);
        return ans;
    }

    private int getMaxPathSum(TreeNode node) {
        if(node==null){
            return 0;
        }
        int lSum = getMaxPathSum(node.left);
        int rSum = getMaxPathSum(node.right);
        int val = node.val;
        int lrMax = Math.max(lSum + val, rSum + val);
        int currMax = Math.max(val,Math.max(lrMax,lSum+rSum+val));
        ans = Math.max(ans,currMax);
        return Math.max(lrMax,val);
    }
}

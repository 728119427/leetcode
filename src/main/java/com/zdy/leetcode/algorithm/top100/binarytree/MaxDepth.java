package com.zdy.leetcode.algorithm.top100.binarytree;

/**
 * 二叉树的最大深度： https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class MaxDepth {

    private int ans = 0;
    public int maxDepth(TreeNode root) {
        maxDepth0(root,0);
        return ans;
    }

    private void maxDepth0(TreeNode root, int temp) {
        if(root==null){
            ans = Math.max(ans,temp);
            return;
        }
        maxDepth0(root.left,temp+1);
        maxDepth0(root.right,temp+1);
    }
}

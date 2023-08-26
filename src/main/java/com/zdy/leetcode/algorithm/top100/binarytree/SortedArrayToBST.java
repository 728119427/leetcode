package com.zdy.leetcode.algorithm.top100.binarytree;

import com.zdy.leetcode.algorithm.top100.normalarray.RotateArray;

/**
 *将有序数组转换为二叉搜索树：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }

    /**
     * 构建BST [-10,-3,0,5,9]
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode buildBST(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums,left,mid-1);
        root.right = buildBST(nums,mid+1,right);
        return root;
    }
}

package com.zdy.leetcode.algorithm.top100.normalarray;

/**
 * 轮转数组：https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&id=top-100-liked
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] rotate = new int[len];
        for (int i = 0; i < len; i++) {
            rotate[(i+k)%len]=nums[i];
        }
        System.arraycopy(rotate,0,nums,0,len);
    }
}

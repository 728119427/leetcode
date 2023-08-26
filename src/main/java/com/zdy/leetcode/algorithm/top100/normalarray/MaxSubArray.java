package com.zdy.leetcode.algorithm.top100.normalarray;

/**
 * 最大子数组和：https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&id=top-100-liked
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
public class MaxSubArray {

    /**
     *
     * [5,4,-1,7,8]
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int ans = Integer.MIN_VALUE;
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans,preSum);
            if(preSum>=0){
                preSum+=nums[i];
            }else {
                preSum = nums[i];
            }
        }
        return Math.max(ans,preSum);
    }
}

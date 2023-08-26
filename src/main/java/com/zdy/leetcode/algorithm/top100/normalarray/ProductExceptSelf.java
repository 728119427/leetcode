package com.zdy.leetcode.algorithm.top100.normalarray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 除自身以外数组的乘积：https://leetcode.cn/problems/product-of-array-except-self/
 *
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在32 位 整数范围内。
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = new ProductExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        leftProduct[0] =1;
        rightProduct[len-1]=1;
        for (int i = 1; i < len; i++) {
            leftProduct[i] = leftProduct[i-1]*nums[i-1];
        }
        for (int i = len-2; i >=0; i--) {
            rightProduct[i] = rightProduct[i+1]*nums[i+1];
        }
        for (int i = 0; i < len; i++) {
            ans[i]=leftProduct[i]*rightProduct[i];
        }
        return ans;
    }
}

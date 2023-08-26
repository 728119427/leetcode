package com.zdy.leetcode.algorithm.top100.normalarray;

import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的第一个正数：https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&id=top-100-liked
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
 */
public class FirstMissingPositive {

    /**
     * 如果数组长度为n，则最小的正数肯定出现在[1,n+1],如果[1,n]都出现了，那么最小正数就是n+1;否则最小正数就是[1,n]中没有出现的那一个最小的
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums){
        //先把数组中小于等于0的数都变成任意一个大于n的数，比如n+1
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]<=0){
                nums[i] = n+1;
            }
        }
        //把数组中出现的在[1,n]范围内的数标记为负数,比如n=6,如果nums[i] = 3,就把索引2处的位置的数变为负数进行标记,
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num<=n){
                nums[num-1] = -Math.abs(nums[num-1]);
            }
        }
        //遍历数组找出最小正数
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                return i+1;
            }
        }
        //如果数组中的数都为负数,则说明[1,n]都出现了,最小正数为n+1;
        return n+1;
    }

    public int firstMissingPositive1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int min=Integer.MAX_VALUE;
        for (int num : nums) {
            numSet.add(num);
            if(num>0 &&num<min){
                min=num;
            }
        }
        if(min!=1){
            return 1;
        }
        for(;;){
            if(!numSet.contains(++min)){
                return min;
            }
        }

    }

}

package com.zdy.leetcode.algorithm.top100.substr;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 和为K的子数组：https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&id=top-100-liked
 *  给你一个整数数组nums和一个整数k请你统计并返回该数组中和为k的连续子数组的个数。
 */
public class SubarraySum {


    /**
     * 前缀和+哈希，pre[i]表示前i个数的和,设j>=0&&j<i,只要有pre[i]-pre[j]=k,即可说明有子串满足和为k,即j到i之和为k
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k){
        int ans=0,sum=0;
        Map<Integer,Integer> preMap = new HashMap<>();
        preMap.put(0,1);
        for (int num : nums) {
            sum+=num;
            if(preMap.containsKey(sum-k)){
                ans+=preMap.get(sum-k);
            }
            preMap.put(sum,preMap.getOrDefault(sum,0)+1);
        }
        return ans;
    }


    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if(sum==k){
                ans++;
            }
            int j = i+1;
            while (j<len){
                sum+=nums[j];
                if(sum==k){
                    ans++;
                }
                j++;
            }
        }
        return ans;
    }
}

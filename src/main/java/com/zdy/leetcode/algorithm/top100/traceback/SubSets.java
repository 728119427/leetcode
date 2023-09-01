package com.zdy.leetcode.algorithm.top100.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集；https://leetcode.cn/problems/subsets/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans,path,nums,0);
        ans.add(path);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int index) {

        for (int i = index; i < nums.length ; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            dfs(ans,path,nums,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }

}

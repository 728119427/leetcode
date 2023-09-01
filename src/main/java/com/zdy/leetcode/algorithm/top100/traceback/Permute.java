package com.zdy.leetcode.algorithm.top100.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列：https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-100-liked
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(len<=0){
            return ans;
        }
        boolean[] used = new boolean[len];
        List<Integer> container = new ArrayList<>();
        dfs(ans,container,used,0,nums);
        return ans;
    }

    /**
     * 回溯
     * @param ans
     * @param container
     * @param used
     * @param depth
     * @param nums
     */
    private void dfs(List<List<Integer>> ans, List<Integer> container, boolean[] used, int depth, int[] nums) {
        if(depth==nums.length){
            ans.add(new ArrayList<>(container));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                container.add(nums[i]);
                used[i]= true;
                dfs(ans,container,used,depth+1,nums);
                //状态变量回溯
                used[i] = false;
                container.remove(container.size()-1);
            }
        }

    }

}

package com.zdy.leetcode.algorithm.top100.binarytree;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和iii：https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSum {


    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> preSumMap = new HashMap<>();
        preSumMap.put(0L,1);
        return dfs(root,preSumMap,0L,targetSum);
    }

    /**
     *
     * @param root
     * @param preSumMap 前缀和集合
     * @param lastPreSum 当前的节点的父节点的前缀和
     * @param targetSum
     */
    private int dfs(TreeNode root, Map<Long, Integer> preSumMap, long lastPreSum, int targetSum) {
        if(root==null){
            return 0;
        }
        long currPreSum = lastPreSum + root.val;
        int res = preSumMap.getOrDefault(currPreSum-targetSum,0);
        preSumMap.put(currPreSum,preSumMap.getOrDefault(currPreSum,0)+1);
        res+=dfs(root.left,preSumMap,currPreSum,targetSum);
        res+=dfs(root.right,preSumMap,currPreSum,targetSum);
        //回溯,向上回溯的过程中需要去除当前节点的前缀和，因为已经不存在了
        preSumMap.put(currPreSum,preSumMap.get(currPreSum)-1);
        return res;
    }


}

package com.zdy.leetcode.algorithm.top100.normalarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 合并区间：https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&id=top-100-liked
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间

 */
public class MergeInterval {


    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len<=1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < len; i++) {
            int[] current = intervals[i];
            if(temp[1]<current[0]){
                list.add(temp);
                temp = current;
            }else if(temp[1]<current[1]){
                temp = new int[]{temp[0],current[1]};
            }
        }
        list.add(temp);
        int size = list.size();
        int[][] ans = new int[size][2];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


}

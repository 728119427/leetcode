package com.zdy.leetcode.algorithm.top100.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表：https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

 */
public class ClassSchedule {

    List<List<Integer>> preList = new ArrayList<>();
    int[] visited ;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preList.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int[] prerequisite = prerequisites[i];
            preList.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            //未探索
            if(visited[i]==0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        //探索中
        visited[i] =1;
        List<Integer> preClazz = preList.get(i);
        for (Integer clazz : preClazz) {
            if(visited[clazz]==0){
                //前置课程未探索
                dfs(clazz);
                if(!valid){
                    return;
                }
            }else if(visited[clazz]==1){
                valid = false;
                return;
            }
        }
        visited[i] =2;
    }
}

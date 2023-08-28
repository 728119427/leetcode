package com.zdy.leetcode.algorithm.top100.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;

/**
 * 腐烂橘子：https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&envId=top-100-liked
 *
 */
public class OrangesRotting {

    /**
     * 广度优先搜索模拟腐烂过程： 模拟的最大层数就是消耗的时间
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,-1,0,1};
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer,Integer> depth = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==2){
                    int coord = i*col + j;
                    queue.offer(coord);
                    //初始的腐烂橘子，深度为0，代表初始消耗时间为0
                    depth.put(coord,0);
                }
            }
        }
        //开始广度优先模拟腐烂橘子
        while (queue.size()>0){
            Integer coord = queue.poll();
            int r = coord/col;
            int c = coord%col;
            for (int k = 0; k < 4; k++) {
                int nr = r+dr[k];
                int nc = c + dc[k];
                if(nr>=0 && nr<row && nc>=0 && nc<col && grid[nr][nc]==1){
                    grid[nr][nc] = 2;
                    int deeperCoord = nr *col + nc;
                    queue.offer(deeperCoord);
                    depth.put(deeperCoord,depth.get(coord)+1);
                    ans = depth.get(deeperCoord);
                }
            }
        }
        //模拟腐烂之后，看是否还有新鲜橘子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}

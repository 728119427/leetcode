package com.zdy.leetcode.algorithm.top100.graph;

import javax.swing.*;

/**
 * 岛屿数量：https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围
 */
public class NumIslands {

     int nr = 0;
     int  nc = 0;

     public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        nr = grid.length;
        nc = grid[0].length;
        int ans = 0;
         for (int i = 0; i < nr; i++) {
             for (int j = 0; j < nc; j++) {
                 if(grid[i][j]=='1'){
                     ans++;
                    dfs(grid,i,j);
                 }
             }
         }
         return ans;
    }

    /**
     * 深度优先搜索,探索岛屿范围，将1置为0
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int r, int c) {
        if(r<0 || c<0 || r>=nr || c>=nc || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}

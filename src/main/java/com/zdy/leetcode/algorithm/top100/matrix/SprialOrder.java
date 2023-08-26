package com.zdy.leetcode.algorithm.top100.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵：https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&id=top-100-liked
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
 */
public class SprialOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list = new SprialOrder().spiralOrder(matrix);
        System.out.println(list);

    }

    /**
     * 使用方向数组
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m*n,row=0,col=0,nextRow=0,nextCol=0,directionIndex=0;
        List<Integer> ans = new ArrayList<>();
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[m][n];
        while (ans.size()<total){
            ans.add(matrix[row][col]);
            visited[row][col] = true;
            nextRow = row+direction[directionIndex][0];
            nextCol = col+direction[directionIndex][1];
            if(nextRow<0 || nextRow>=m || nextCol<0 || nextCol>=n ||visited[nextRow][nextCol]){
                directionIndex = (directionIndex+1)%4;
            }
            row+=direction[directionIndex][0];
            col+=direction[directionIndex][1];
        }
        return ans;

    }


}

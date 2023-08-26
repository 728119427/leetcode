package com.zdy.leetcode.algorithm.top100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵置零：https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&id=top-100-liked
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为0。请使用原地算法
 */
public class setZeroes {

    public void setZeroes(int[][] matrix) {
        int len = matrix.length;
        int col = matrix[0].length;
        List<int[]> zeroList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] subMatrix = matrix[i];
            for (int j = 0; j < subMatrix.length; j++) {
                if(subMatrix[j]==0){
                    zeroList.add(new int[]{i,j});
                }
            }
        }
        for (int[] ints : zeroList) {
            int raw = ints[0];
            int column = ints[1];
            //将列设为0
            for (int i = 0; i < len; i++) {
                matrix[i][column]=0;
            }
            //将行设为0
            for (int i = 0; i < col; i++) {
                matrix[raw][i]=0;
            }

        }
    }
}

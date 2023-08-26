package com.zdy.leetcode.algorithm.top100.matrix;

/**
 * 旋转图像：https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&id=top-100-liked
 *
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class RotatePicture {

    /**
     * 旋转后第一行变最后一列,列变行;
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int newColumn = n-1-i;
            for (int j = 0; j < n; j++) {
                temp[j][newColumn] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}

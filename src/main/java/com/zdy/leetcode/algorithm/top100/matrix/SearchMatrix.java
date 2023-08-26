package com.zdy.leetcode.algorithm.top100.matrix;

import java.util.TreeMap;

/**
 * 搜索二维矩阵II：https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&id=top-100-liked
 *
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchMatrix {

    /**
     * z字型查找,从右上角开始搜索，往左下角收缩，如果matrix[x][y]>target，则只能向左收缩,反之向下收缩
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int x=0,y=n-1;
        while (x<m && y>=0){
            int current = matrix[x][y];
            if(current==target){
                return true;
            }
            if(current>target){
                //向左收缩
                y--;
            }else {
                //向下收缩
                x++;
            }
        }
        return false;
    }


    /**
     * 使用二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int ans = binarySearch(matrix[i],target);
            if(ans!=-1){
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] nums,int target){
        int low = 0,high=nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
}

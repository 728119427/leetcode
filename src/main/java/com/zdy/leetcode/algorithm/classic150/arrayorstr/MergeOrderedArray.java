package com.zdy.leetcode.algorithm.classic150.arrayorstr;

import com.sun.jndi.ldap.Ber;

/**
 * 合并有序的数组：https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&id=top-interview-150
 *
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

 */
public class MergeOrderedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int aPointer = 0;
        int bPointer = 0;
        int[] merge = new int[m+n];
        int current = 0;
        while (aPointer<m ||bPointer<n){
            if(aPointer==m){
                current = nums2[bPointer++];
            }else if(bPointer==n){
                current = nums1[aPointer++];
            }else if(nums1[aPointer]<nums2[bPointer]){
                current = nums1[aPointer++];
            }else {
                current = nums2[bPointer++];
            }
            merge[aPointer+bPointer-1] = current;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merge[i];
        }
    }
}

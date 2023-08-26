package com.zdy.leetcode.algorithm.top100.binarytree;

/**
 * @Description TODO
 * @Author zhengdongyuan@hanyangtech.cn
 * @Date 2023/6/12 10:04
 */
public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;

     TreeNode() {}

     TreeNode(int val) { this.val = val; }

     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

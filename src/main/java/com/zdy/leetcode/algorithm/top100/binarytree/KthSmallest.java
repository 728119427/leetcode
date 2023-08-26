package com.zdy.leetcode.algorithm.top100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  二叉搜索树中第k小的元素：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-100-liked
 *  给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KthSmallest {

    /**
     * 递归实现，二叉搜索树的中序遍历是升序的，所以这里使用中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        getKthSmallest(root,k,list);
        return list.get(k-1);
    }

    private void getKthSmallest(TreeNode root, int k, List<Integer> list) {
        if(list.size()==k){
            return ;
        }
        if(root.left!=null){
            getKthSmallest(root.left,k,list);
        }
        if(list.size()==k){
            return ;
        }
        list.add(root.val);
        if(root.right!=null){
            getKthSmallest(root.right,k,list);
        }
    }

    /**
     * 迭代实现
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestByIter(TreeNode root, int k){
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root=stack.pop();
            k--;
            if(0==k){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}

package com.zdy.leetcode.algorithm.top100.binarytree;

import java.util.*;

/**
 * 二叉树展开为链表： https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
 *
 *给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {

    /**
     * 递归遍历，然后再展开为链表
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        traversal(root,nodeList);
        for (int i = 0; i < nodeList.size()-1; i++) {
            nodeList.get(i).right=nodeList.get(i+1);
        }
    }

    private void traversal(TreeNode root, List<TreeNode> nodeList) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        nodeList.add(root);
        if(left!=null){
            traversal(left,nodeList);
        }
        if(right!=null){
            traversal(right,nodeList);
        }
    }

    /**
     * 迭代实现，遍历过程中展开链表
     * @param root
     */
    public void flattenByIter1(TreeNode root){
        Deque<TreeNode> stack  = new LinkedList<>();
        TreeNode pre=null,cur=null;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                if(pre==null){
                    pre =cur= root;
                }else {
                    cur = root;
                    pre.right = cur;
                }
                if(root.right!=null){
                    stack.push(root.right);
                }
                TreeNode left = root.left;
                root.left = null;
                root = left;
                pre = cur;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
            }
        }
    }

    /**
     * 迭代实现，前序遍历2
     * @param root
     */
    public void flattenByIter2(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode pre = null,cur = null;
        while (!stack.isEmpty()){
            cur  = stack.pop();
            if(pre!=null){
                pre.left = null;
                pre.right = cur;
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
            pre = cur;
        }
    }
}

package com.zdy.leetcode.algorithm.top100.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树：https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class IsSymmetric {

    /**
     * 递归实现
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return p.val==q.val &&check(p.left,q.right)&&check(p.right,q.left);
    }

    /**
     * 迭代判断二叉树的对称性
     * @param root
     * @return
     */
    public boolean isSymmetricByIter(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1==null && node2==null){
                continue;
            }
            if((node1==null||node2==null) || node1.val!= node2.val){
                return false;
            }
            if(node1==node2){
                stack.push(node1.left);
                stack.push(node2.right);
            }else {
                stack.push(node1.left);
                stack.push(node2.right);
                stack.push(node1.right);
                stack.push(node2.left);
            }

        }
        return true;
    }
}

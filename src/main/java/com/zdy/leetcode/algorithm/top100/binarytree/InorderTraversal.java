package com.zdy.leetcode.algorithm.top100.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中序遍历：https://leetcode.cn/problems/binary-tree-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked
 */
public class InorderTraversal {

    private List<Integer> ans = new ArrayList<>();
    /**
     * 递归中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null){
            return ans;
        }
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        ans.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return ans;
    }

    /**
     * 迭代实现中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByIter(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * 迭代前序遍历
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalByIter(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                ans.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                root = root.left;
            }
            root = stack.pop();
        }
        return ans;
    }

    /**
     * 迭代前序遍历
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalByIter0(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            ans.add(root.val);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return ans;
    }

    /**
     * 迭代后续遍历
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversalByIter(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> operateStack = new LinkedList<>();
        Deque<TreeNode> resStack = new LinkedList<>();
        operateStack.push(root);
        while (!operateStack.isEmpty()){
            root = operateStack.pop();
            resStack.push(root);
            if(root.left!=null){
                operateStack.push(root.left);
            }
            if(root.right!=null){
                operateStack.push(root.right);
            }
        }
        while (!resStack.isEmpty()){
            ans.add(resStack.pop().val);
        }
        return ans;
    }
}

package com.zdy.leetcode.algorithm.top100.binarytree;

import java.util.*;

/**
 * 二叉树的层序遍历：https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）
 */
public class LevelOrder {

    /**
     * 迭代实现层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> stack =  new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            while (size>0){
                TreeNode treeNode = stack.pollLast();
                list.add(treeNode.val);
                size--;
                if(treeNode.left!=null){
                    stack.push(treeNode.left);
                }
                if(treeNode.right!=null){
                    stack.push(treeNode.right);
                }

            }
            ans.add(list);
        }
        return ans;
    }


    /**
     * 递归实现层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderByRecursion(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> listMap = new HashMap<>();
        recursionTraversal(root,1,ans,listMap);
        return ans;
    }

    private void recursionTraversal(TreeNode root, int level, List<List<Integer>> ans, Map<Integer, List<Integer>> listMap) {
        if(root==null){
            return;
        }
        List<Integer> levelList = listMap.get(level);
        if(levelList==null){
            levelList = new ArrayList<>();
            listMap.put(level,levelList);
            ans.add(levelList);
        }
        levelList.add(root.val);
        if(root.left!=null){
            recursionTraversal(root.left,level+1,ans,listMap);
        }
        if(root.right!=null){
            recursionTraversal(root.right,level+1,ans,listMap);
        }

    }
}

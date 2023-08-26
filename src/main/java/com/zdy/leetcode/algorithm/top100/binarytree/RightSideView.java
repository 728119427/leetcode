package com.zdy.leetcode.algorithm.top100.binarytree;

import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

/**
 * 二叉树的右视图：https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 */
public class RightSideView {

    /**
     * 深度优先，中序遍历，不过是先遍历右节点再遍历左节点，记录每一深度第一个遍历的节点即可
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> levelSet = new HashSet<>();
        getRightSideView(root,ans,levelSet,1);
        return ans;
    }

    private void getRightSideView(TreeNode root, List<Integer> ans, Set<Integer> levelSet, int level) {
        if(root==null){
            return;
        }
        if(!levelSet.contains(level)){
            levelSet.add(level);
            ans.add(root.val);
        }
        if(root.right!=null){
            getRightSideView(root.right,ans,levelSet,level+1);
        }
        if(root.left!=null){
            getRightSideView(root.left,ans,levelSet,level+1);
        }
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<Integer> rightSideViewByBFS(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            boolean flag = false;
            int size = queue.size();
            while (size>0){
                 root= queue.poll();
                 if(!flag){
                     ans.add(root.val);
                     flag = true;
                 }
                 if(root.right!=null){
                     queue.offer(root.right);
                 }
                 if(root.left!=null){
                     queue.offer(root.left);
                 }
                 size--;
            }
        }
        return ans;
    }
}

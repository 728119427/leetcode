package com.zdy.leetcode.algorithm.top100.binarytree;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 验证二叉搜索树：https://leetcode.cn/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {

    private boolean flag = true;

    /**
     * 递归判断
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long lower, long upper) {
        if(root==null){
            return true;
        }
        if(root.val<=lower || root.val>=upper){
            return false;
        }
        return isValid(root.left,lower,root.val) && isValid(root.right,root.val,upper);
    }

    /**
     * 通过迭代实现中序遍历判断,二叉搜索树的中序遍历是升序的。
     * @param root
     * @return
     */
    public boolean isValidBSTByIter(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        long lastValue = Long.MIN_VALUE;
        while (!stack.isEmpty() || root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val<=lastValue){
                return false;
            }
            lastValue = root.val;
            root = root.right;
        }
        return true;
    }


}

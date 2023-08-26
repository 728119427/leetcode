package com.zdy.leetcode.algorithm.top100.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 *从前序与中序遍历序列构造二叉树：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked
 * 给定两个整数数组preorder 和 inorder，其preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 */
public class BuildTree {

    private Map<Integer,Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree0(preorder,inorder,0,len-1,0,len-1);
    }

    private TreeNode buildTree0(int[] preorder, int[] inorder, int preOrderLeft, int preorderRight, int inOrderLeft, int inOrderRight) {
        if(preOrderLeft>preorderRight){
            return null;
        }
        //前序遍历根节点的位置
        int preOrderRootIndex = preOrderLeft;
        //定位中序遍历根节点的位置
        int inOrderRootIndex = indexMap.get(preorder[preOrderRootIndex]);
        //确定左子树的数量
        int leftSubTreeNum = inOrderRootIndex-inOrderLeft;
        //构造根节点
        TreeNode root = new TreeNode(preorder[preOrderRootIndex]);
        //构造根节点左子树
        root.left = buildTree0(preorder,inorder,preOrderRootIndex+1,preOrderRootIndex+leftSubTreeNum,inOrderLeft,inOrderRootIndex-1);
        //构造根节点右子树
        root.right = buildTree0(preorder,inorder,preOrderRootIndex+leftSubTreeNum+1,preorderRight,inOrderRootIndex+1,inOrderRight);
        return root;
    }

}

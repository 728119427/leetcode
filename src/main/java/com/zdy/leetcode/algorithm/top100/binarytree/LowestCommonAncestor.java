package com.zdy.leetcode.algorithm.top100.binarytree;

/**
 * 二叉树的最近公共祖先：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。

 */
public class LowestCommonAncestor {

    private TreeNode ans;


    /**
     * 递归遍历，深度优先；
     * 1）如果某个节点的左子树包含p或q并且右子树包含p或q，则该节点就是最近的公共祖先
     * 2）如果某个节点刚好是p或q，并且它的左子树或者右子树包含p或q，则该节点就是最近的公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }

    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if(node==null){
            return false;
        }
        boolean lSon = dfs(node.left, p, q);
        boolean rSon = dfs(node.right,p,q);
        if( lSon&&rSon || (node==p||node==q&&(lSon||rSon)) ){
            this.ans = node;
        }
        return lSon ||rSon||node==p||node==q;
    }
}

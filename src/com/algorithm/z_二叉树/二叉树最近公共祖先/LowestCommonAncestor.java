package com.algorithm.z_二叉树.二叉树最近公共祖先;

import com.algorithm.z_二叉树.TreeNode;

/**
 * @author Ernest Chen
 * @date 3/11/21 10:19 PM.
 */
public class LowestCommonAncestor {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) 递归使用JVM栈
     * DFS 后序遍历
     *
     * @param root 二叉树根节点
     * @param p    一个二叉树节点
     * @param q    一个二叉树节点
     * @return 两个节点最近的父亲节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p q分别在左右子树上
        //p q在左子树上
        //p q在右子树上
        if (root == null) {
            return null;
        }
        //最近公共祖先节点可以为节点本身
        //p = root 或者 q = root
        if (p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        //left != null && right != null
        return root;
    }
}
package com.algorithm.剑指offer.树的子结构;

/**
 * @author Ernest Chen
 * @date 2/22/21.
 */
public class HasSubtree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断B树是不是A树的子树
     *
     * @param A 父树
     * @param B 子树
     * @return
     */
    public boolean hasSubtree(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubtree(A, B) || hasSubtree(A.left, B) || hasSubtree(A.right, B);
    }

    public boolean isSubtree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return isSubtree(a.left, b.right) && isSubtree(a.right, b.right);
    }
}

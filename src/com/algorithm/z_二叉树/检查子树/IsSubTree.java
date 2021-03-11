package com.algorithm.z_二叉树.检查子树;

import com.algorithm.z_二叉树.TreeNode;

/**
 * @author Ernest Chen
 * @date 3/8/21 8:53 PM.
 */
public class IsSubTree {

    public boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (t2 == null) {
            return true;
        }
        return isSameTree(t1, t2) || isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }

    public boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }
}

package com.algorithm.z_二叉树.对称二叉树;

import com.algorithm.z_二叉树.TreeNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 10:50 AM.
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}

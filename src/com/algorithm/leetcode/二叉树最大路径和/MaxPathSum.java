package com.algorithm.leetcode.二叉树最大路径和;

/**
 * @author chenhuarui
 * @date 2020/4/10.
 * leetcode[124]
 */
public class MaxPathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    /**
     * 后序遍历
     * 注意：返回的是二叉树一支分路的最大val + root.val
     */
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

package com.algorithm.z_二叉树;

/**
 * @author Ernest Chen
 * @date 3/7/21 10:47 PM.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}

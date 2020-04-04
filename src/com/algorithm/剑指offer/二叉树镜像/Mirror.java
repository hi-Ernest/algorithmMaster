package com.algorithm.剑指offer.二叉树镜像;

import java.util.Stack;

/**
 * create by Ernest on 2020/3/11.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Mirror {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        Mirror(root.left);
        Mirror(root.right);
    }

    /**
     * 栈 -> 交换left right节点
     * @param root
     */
    public void mirror_non_recursive(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null || cur.right != null) {
                TreeNode tmpNode = cur.left;
                cur.left = cur.right;
                cur.right = tmpNode;
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
    }
}

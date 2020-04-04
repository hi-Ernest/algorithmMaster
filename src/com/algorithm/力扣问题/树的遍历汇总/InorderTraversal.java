package com.algorithm.力扣问题.树的遍历汇总;

import java.util.*;

/**
 * create by Ernest on 2020/3/7.
 */
public class InorderTraversal {


    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        return inorderTraversal(res, root);
    }

    private List<Integer> inorderTraversal(List<Integer> res, TreeNode root) {

        if (root.left != null) {
            inorderTraversal(res, root.left);
        }

        if (root != null) {
            res.add(root.val);
        }

        if (root.right != null) {
            inorderTraversal(res, root.right);
        }
        return res;
    }


    /**
     * 非递归 -> 使用栈 类似preorderTraversal
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_using_stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /**
     * OG
     * @param root
     * @return
     */
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> rstack = new Stack<>();

        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                rstack.push(root.right);
            }
            root = root.left;
            if (root == null && !rstack.isEmpty()) {
                root = rstack.pop();
            }
        }
        return res;
    }
}

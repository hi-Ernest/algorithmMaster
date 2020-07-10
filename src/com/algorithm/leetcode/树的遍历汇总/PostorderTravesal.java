package com.algorithm.leetcode.树的遍历汇总;

import java.util.*;

/**
 * create by Ernest on 2020/3/7.
 */
public class PostorderTravesal {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        return postorderTraversal(res, root);
    }

    public List<Integer> postorderTraversal(List<Integer> res, TreeNode root) {
        if (root.left != null) {
            postorderTraversal(res, root.left);
        }

        if (root.right != null) {
            postorderTraversal(res, root.right);
        }

        if (root != null) {
            res.add(root.val);
        }

        return res;
    }

    /**
     * 非递归 -> 使用栈
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_iteratively(TreeNode root) {
        //关键
        LinkedList<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
           if (root != null) {
               stack.push(root);
               res.addFirst(root.val);
               root = root.right;
           }else {
               root = stack.pop().left;
           }
        }

        return res;
    }

}

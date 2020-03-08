package com.dataStructure;

import java.util.*;

/**
 * create by Ernest on 2020/3/7.
 */
public class PreorderTraversal {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return preorderTraversal(res, root);
    }

    private List<Integer> preorderTraversal(List<Integer> res, TreeNode root) {
        if (root != null) {
            res.add(root.val);
        }

        if (root.left != null) {
            preorderTraversal(res, root.left);
        }

        if (root.right != null) {
            preorderTraversal(res, root.right);
        }

        return res;
    }


    public List<Integer> preorderTraversal_using_queue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
}

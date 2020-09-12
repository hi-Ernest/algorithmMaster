package com.algorithm.leetcode.恢复二叉搜索树;

import java.util.*;

/**
 * @author chenhuarui
 * @date 2020/4/10.
 *
 * leetcode[99]
 * 二叉搜索树（BST）的两个元素被错误交换。 恢复树而不更改其结构。
 */
public class RecoverTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 因为使用中序遍历，pre记录上一个节点，与当前节点比较val -> 找出错位节点
     * 使用first和second节点存储BST中错位的两个节点，最后交换两者的val
     */
    TreeNode pre = null, first = null, second = null;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        if (first != null && second != null) {
            swap(first, second);
        }
    }

    public void helper(TreeNode root) {
        if (root.left != null) {
            helper(root.left);
        }
        if (pre != null && root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            if (first != null) {
                second = root;
            }
        }
        pre = root;
        if (root.right != null) {
            helper(root.right);
        }
    }

    public void swap(TreeNode first, TreeNode second) {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


    public void recoverTree_none_recursive(TreeNode root) {
        TreeNode pre = null, first = null, second = null;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (pre != null) {
                if (pre.val > temp.val) {
                    if (first == null) {
                        first = pre;
                    }
                    second = temp;
                }
            }
            pre = temp;
            if (temp.right != null) {
                temp = temp.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}

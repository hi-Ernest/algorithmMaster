package com.algorithm.剑指offer.二叉搜索树的第K个节点;

import java.util.*;
/**
 * create by Ernest on 2020/3/9.
 *
 * 给一棵二叉搜索树 -> 求第K小的节点
 * ex:（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    LinkedList<TreeNode> list = new LinkedList<>();

    /**
     * 二叉搜索树(左节点总小于父节点，且右节点总大于父节点)
     * 树的中序遍历(递归) + list.get(k-1)
     * @param root
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode root, int k) {

        inorderTraversal(root);

        if (k >= 1 || list.size() >= k) {
            return list.get(k-1);
        }
        return null;
    }

    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            list.add(root);
            inorderTraversal(root.right);
        }
    }

    /**
     * 中序遍历(非递归) + 计数操作
     * @param root
     * @param k
     * @return
     */
    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (k-- == 0) {
                return root;
            }
            root = root.right;
        }
        return null;
    }
}

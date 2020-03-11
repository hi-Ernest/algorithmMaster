package com.dataStructure;

import java.util.*;
/**
 * create by Ernest on 2020/3/9.
 * 给一棵二叉搜索树 -> 求第K大节点
 */
public class KthNode {

    LinkedList<TreeNode> list = new LinkedList<>();

    /**
     * 递归
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
     * 中序遍历 + 计数操作
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

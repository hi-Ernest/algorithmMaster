package com.algorithm.z_二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ernest Chen
 * @date 2/21/21.
 */
public class TreeTraverse {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    private List<Integer> res = new LinkedList<>();

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }

    /**
     * 需要先遍历根、左边、才到右边
     * 非递归就遍历完根（pop出）先push右边，在push左边
     *
     * @param root 树的根节点
     */
    public void preOrderNoRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrderNoRecursive(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    public void postOrderNoRecursive(TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode val = new TreeNode(4);
        TreeNode val2 = new TreeNode(5);
        TreeNode val3 = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = val;
        left.right = val2;
        right.right = val3;
        TreeTraverse tt  = new TreeTraverse();
//        tt.preOrder(root);
//        System.out.println(res);
//
//        tt.inOrder(root);
//        System.out.println(res);
//
//        tt.postOrder(root);
//        System.out.println(res);

        tt.preOrderNoRecursive(root);
    }
}

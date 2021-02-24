package com.algorithm.z_二叉树;

/**
 * @author Ernest Chen
 * @date 2/17/21.
 */
public class BinarySearchTree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private TreeNode root;

    /**
     * 二叉查找树-查找时间复杂度：O(logN)
     * 最好时间复杂度：O(logN)
     * 最坏时间复杂度：O(N) [退化成链表]
     *
     * @param data 待查找节点的value
     * @return 返回该查找的节点
     */
    public TreeNode findTreeNode(int data) {
        TreeNode p  = root;
        while (p != null) {
            if (p.data == data) {
                return p;
            }else if (p.data < data) {
                p = p.left;
            }else {
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 最好时间复杂度：O(logN)
     * 最坏时间复杂度：O(N) [退化成链表]
     *
     * @param data 待删除节点的value
     */
    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode p = root;
        while (p != null) {
            if (p.data > data) {
                if (p.left == null) {
                    TreeNode newNode = new TreeNode(data);
                    p.left = newNode;
                    return;
                }
                p = p.left;
            }else if (p.data < data) {
                if (p.right == null) {
                    TreeNode newNode = new TreeNode(data);
                    p.right = newNode;
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 先查找树是否存在该value值的节点 - 找到该节点
     * 三种情况 {
     *     1.删除节点有左右两个子节点
     *     2.删除节点仅由左/右一个子节点
     *     3.删除节点为叶子节点，无子节点
     * }
     * @param data 待删除节点的value
     */
    public void delete(int data) {
        //找到待删除的节点,使用p来存储该节点
        TreeNode p = root;
        TreeNode parentP = null;
        while (p != null && p.data != data) {
            parentP = p;
            if (p.data > data) {
                p = p.left;
            }else {
                p = p.right;
            }
        }
        //该树不存在该节点
        if (p == null) {
            return;
        }

        //第一种情况：待删除节点为父节点，有左右两个子节点
        //找到该节点右子树-最左边节点
        if (p.left != null && p.right != null) {
            TreeNode parentMinNode = p;
            TreeNode minNode = p.right;
            while (minNode.left != null) {
                parentMinNode = minNode;
                minNode = minNode.left;
            }
            //将minNode的data赋值给待删除节点
            p.data = minNode.data;
            //之后操作删除minNode，赋值转化成"删除节点是叶子节点或者仅有一个子节点"问题
            p = minNode;
            parentP = parentMinNode;
        }

        //删除节点是叶子节点或者仅有一个子节点
        //获取minNode的儿子节点
        //优先左节点
        TreeNode child = null;
        if (p.left != null) {
            child = p.left;
        }else if (p.right != null) {
            child = p.right;
        }else {
            child = null;
        }

        if (parentP == null) {
            root = child;
        }else if (parentP.left == p) {
            parentP.left = child;
        }else {
            parentP.right = child;
        }

    }

}

package com.algorithm.z_二叉树.反转二叉树;

import com.algorithm.z_二叉树.合并二叉树.MergeTrees;

import java.util.*;
/**
 * @author Ernest Chen
 * @date 3/7/21 10:24 PM.
 */
public class InvertTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 深度优先遍历 = 前序遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root 根节点
     * @return 返回根节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 广度优先遍历 = 层次遍历
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root 根节点
     * @return 返回根节点
     */
    public TreeNode invertTree4Queue(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }

        }
        //返回处理完的根节点
        return root;
    }

}

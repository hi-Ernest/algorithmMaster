package com.dataStructure;

import java.util.*;

public class TreeDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0)
                    ? left + right + 1
                        : Math.min(left, right) + 1;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0
                    : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 非递归-层次遍历
     * @param root
     * @return
     */
    public int maxDepth_non_recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}

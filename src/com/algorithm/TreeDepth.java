package com.algorithm;

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

    public int maxDepth(TreeNode root) {
        return root == null ? 0
                    : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

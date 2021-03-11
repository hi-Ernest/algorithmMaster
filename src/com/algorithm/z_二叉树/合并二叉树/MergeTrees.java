package com.algorithm.z_二叉树.合并二叉树;

/**
 * @author Ernest Chen
 * @date 3/7/21 9:53 PM.
 */
public class MergeTrees {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 时间复杂度：O(min(M, N))
     * 空间复杂度：O(min(M, N))
     *
     * dfs深度优先遍历
     * @param root1 A树
     * @param root2 B树
     * @return 合并val的树
     *
     * 1.左右节点不为空 - val相加
     * 2.左右节点一个为空 - 要非空节点val
     * 3.都为空 - 不添加还是null
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode cur = new TreeNode(root1.val + root2.val);
        cur.left = mergeTrees(root1.left, root2.left);
        cur.right = mergeTrees(root1.right, root2.right);
        return cur;
    }
}

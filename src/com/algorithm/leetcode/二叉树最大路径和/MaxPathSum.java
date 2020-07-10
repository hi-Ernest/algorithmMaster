package com.algorithm.leetcode.二叉树最大路径和;

/**
 * create by Ernest on 2020/4/10.
 *
 * leetcode[124]
 * 对于此问题，路径定义为沿着父子连接从某个起始节点到树中任何节点的任何节点序列。
 * 该路径必须至少包含一个节点，并且不需要通过根。
 *
 * ex:
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 */
public class MaxPathSum {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    /**
     * 后序遍历
     * 注意：返回的是二叉树一支分路的最大val + root.val
     * @param root
     * @return
     */
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}

package com.algorithm.leetcode.根据前中遍历构造树;

/**
 * create by Ernest on 2020/4/10.
 *
 * leetcode[105]
 */
public class BuildTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return treeNode;
    }

    /**
     * 前序遍历
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode helper(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                root.left = helper(preorder, preStart + 1, i - inStart + preStart, inorder, inStart, i - 1);
                root.right = helper(preorder, i - inStart + preStart + 1, preEnd, inorder, i + 1, inEnd);
            }
        }
        return root;
    }
}

package com.dataStructure;

/**
 * create by Ernest on 2020/3/10.
 */
public class IsBalanced {

    /**
     * 递归 -> 最大tree深度 + math.abs(left - right) <= 1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int treeDepth(TreeNode root) {
        return root == null ? 0 :
                1 + Math.max(treeDepth(root.left), treeDepth(root.right));
    }

    /**
     * 自底向上优化
     * @param root
     * @return
     */
    public boolean isBalanced_non_recursive(TreeNode root) {
        if (root == null) {
            return true;
        }

        return treeHeight(root) != -1;
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ltree = treeHeight(root.left);
        if (ltree == -1) {
            return -1;
        }

        int rtree = treeHeight(root.right);
        if (rtree == -1) {
            return -1;
        }

        if (Math.abs(ltree - rtree) > 1) {
            return -1;
        }

        return  1 + Math.max(ltree, rtree);
    }

}

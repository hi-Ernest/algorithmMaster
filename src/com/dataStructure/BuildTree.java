package com.dataStructure;

import com.algorithm.DP.MinPathSum;

/**
 * create by Ernest on 2020/3/10.
 *
 * 前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}
 * 则重建二叉树并返回。
 */
public class BuildTree {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left =
                        reConstructBinaryTree(pre, startPre + 1, i - startIn + startPre, in, startIn, i - 1);

                root.right =
                        reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in,  i + 1, endIn);
            }
        }

        return root;
    }
}

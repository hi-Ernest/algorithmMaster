package com.algorithm.z_二叉树.验证二叉搜索树;

import com.algorithm.z_二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ernest Chen
 * @date 3/9/21 3:28 PM.
 */
public class IsValidBST {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) 栈存储节点
     * @param root 根节点
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        //关键
        double pre = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode cur = stack.pop();
            if (cur.val <= pre) {
                return false;
            }
            pre = cur.val;
            root = cur.right;
        }
        return true;
    }
}

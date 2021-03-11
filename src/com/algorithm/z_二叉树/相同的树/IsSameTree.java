package com.algorithm.z_二叉树.相同的树;

import com.algorithm.z_二叉树.TreeNode;

/**
 * @author Ernest Chen
 * @date 3/7/21 10:46 PM.
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1.两个都不为空 比较数值
        //2.一个为空 则直接false
        //两个都为空 true
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

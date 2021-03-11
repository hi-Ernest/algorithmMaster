package com.algorithm.z_二叉树.树的子结构;

import com.algorithm.z_二叉树.TreeNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 12:21 PM.
 */
public class IsSubStructure {
    //输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    //B是A的子结构， 即 A中有出现和B相同的结构和节点值。

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //1.判断空树情况
        if (A == null || B == null) {
            return false;
        }
        return doesHaveSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean doesHaveSub(TreeNode A, TreeNode B) {
        //B走完
        if (B == null) {
            return true;
        }
        //B没有走完A走完
        if (A == null || A.val != B.val) {
            return false;
        }
        return doesHaveSub(A.left, B.left) && doesHaveSub(A.right, B.right);
    }
}

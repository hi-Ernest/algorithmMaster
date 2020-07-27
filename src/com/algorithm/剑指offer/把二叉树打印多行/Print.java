package com.algorithm.剑指offer.把二叉树打印多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ernest Chen
 * @date 2020/7/27.
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Print {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 层次遍历
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(pRoot);
        int start = 0, end = 1;

        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            list.add(cur.val);
            start++;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (start == end) {
                end = queue.size();
                start = 0;
                result.add(list);
                list = new ArrayList<>();
            }
        }
        return result;
    }





}

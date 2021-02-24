package com.algorithm.剑指offer.按之字形打印二叉树;

import java.util.*;

/**
 * create by Ernest on 2020/3/8.
 */
public class ZigzagLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 解决：就是层次遍历的 + 间接性反转
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //关键
            LinkedList<Integer> subList = new LinkedList<>();
            //每层节点数量
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (res.size() % 2 == 0) {
                    subList.add(cur.val);
                }else {
                    subList.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(subList);
        }
        return res;
    }

    /**
     * 返回的为类型为 -> ArrayList<ArrayList<Integer>>
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder_(TreeNode root) {
        //关键
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (res.size() % 2 == 0) {
                    subList.add(cur.val);
                }else {
                    subList.add(0, cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(subList);
        }
        return res;
    }
}

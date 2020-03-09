package com.dataStructure;

import java.util.*;

/**
 * create by Ernest on 2020/3/8.
 */
public class ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> subList = new LinkedList<>();
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



    public ArrayList<ArrayList<Integer>> zigzagLevelOrder_(TreeNode root) {
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

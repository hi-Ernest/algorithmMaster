package com.dataStructure;

import java.util.*;

/**
 * create by Ernest on 2020/3/8.
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder_(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new LinkedList<>();
            int levelNums = queue.size();
            for (int i = 0; i < levelNums; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            res.add(subList);
        }
        return res;
    }





    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        return bfs(res, root);
    }

    private List<List<Integer>> bfs(List<List<Integer>> res, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode outNode = queue.poll();
                itemList.add(outNode.val);
                if (outNode.left != null) {
                    queue.add(outNode.left);
                }

                if (outNode.right != null) {
                    queue.add(outNode.right);
                }
            }
            res.add(itemList);
        }
        return res;
    }




}

package com.algorithm;
import java.util.*;

public class DFS {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> resList = new ArrayList<>();

        return resList;
    }

    public void dfs(TreeNode root, List<List<Integer>> list, int level) {
        if (root == null) return;
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(root.val);
        dfs(root.left, list, level + 1);
        dfs(root.right, list, level + 1);
    }
}

package com.algorithm.剑指offer.二叉树中和为某值的路径;

import java.util.*;
/**
 * create by Ernest on 2020/4/3.
 */
public class FindPath {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    //返回结果
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    //记录一条符合的路径
    private ArrayList<Integer> item = new ArrayList<>();

    /**
     * 递归
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return res;
        }

        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            item.add(root.val);
            res.add(new ArrayList<>(item));
            item.remove(item.size() - 1);
        }
        item.add(root.val);
        FindPath(root.left, target);
        FindPath(root.right, target);
        //回退
        item.remove(item.size() - 1);
        return res;
    }

}
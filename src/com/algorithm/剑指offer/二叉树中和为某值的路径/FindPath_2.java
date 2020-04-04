package com.algorithm.剑指offer.二叉树中和为某值的路径;

import java.util.*;
/**
 * create by Ernest on 2020/4/3.
 */
public class FindPath_2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> resultsList = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {
            return resultsList;
        }

        int curSum = 0;
        int index = 0;
        int []path = new int[1000];
        this.isTargetPath(root, target, curSum, path, index);

        return this.resultsList;
    }

    private void isTargetPath(TreeNode curRoot, int target, int curSum, int[] path, int index) {
        if (curRoot == null) {
            return;
        }

        curSum += curRoot.val;
        path[index] = curRoot.val;
        index++;

        if (curSum == target && curRoot.left == null && curRoot.right == null) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                item.add(path[i]);
            }
            resultsList.add(item);
            return;
        }

        if (curSum < target && curRoot.left != null) {
            isTargetPath(curRoot.left, target, curSum, path, index);
        }

        if (curSum < target && curRoot.right != null) {
            isTargetPath(curRoot.right, target, curSum, path, index);
        }
    }
}

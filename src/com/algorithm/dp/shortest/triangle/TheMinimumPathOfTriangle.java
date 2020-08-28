package com.algorithm.dp.shortest.triangle;

import java.util.*;

/**
 * triangle:
 * [0,0]
 * [1,0] [1,1]
 * [2.0] [2.1] [2.2]
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * leetcode[120]
 *
 * @author chenhuarui
 */
public class TheMinimumPathOfTriangle {

    private static final int GLOBAL_TWO = 2;

    public int minimumTotal_(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        for (int i = triangle.size() - GLOBAL_TWO; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                min += triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     * optimize
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row + 1];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思维变换 -> 可看作二叉树的，转变求以下问题：
     * <p>
     * 给定一个二叉树和一个目标和
     * 判断该树中是否存在根节点到叶子节点的路径
     * 这条路径上所有节点值相加等于目标和。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return false;
    }
}

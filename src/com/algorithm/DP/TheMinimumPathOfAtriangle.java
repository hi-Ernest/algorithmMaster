package com.algorithm.DP;

import java.util.*;

public class TheMinimumPathOfAtriangle {

    public int minimumtotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] dp = new int[row + 1];

        /**
         * triangle:
         * [0,0]
         * [1,0] [1,1]
         * [2.0] [2.1] [2.2]
         */
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
          TreeNode(int x) { val = x; }
     }

    /**
     * 给定一个二叉树和一个目标和
     * 判断该树中是否存在根节点到叶子节点的路径
     * 这条路径上所有节点值相加等于目标和。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return false;
    }
}

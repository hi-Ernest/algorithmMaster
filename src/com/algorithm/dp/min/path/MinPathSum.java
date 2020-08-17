package com.algorithm.dp.min.path;

/**
 * @author Ernest Chen
 * @date 2020/3/2.
 *
 * leetcode[64]
 * Given an M x N grid with non-negative integers, find a path from top left to bottom right
 * that minimizes the sum of the Numbers on the path.
 * Explanation: You can only move one step down or one step to the right at a time.
 *
 * exp:
 * input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * output: 7
 * explanation: Because 1→3→1→1→1 the sum of the minimum.
 */
public class MinPathSum {

    /**
     * time：O(m * n)
     * space：O(m * n) -> optimize: O(1)
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][column - 1];
    }

    /**
     * space：O(1)
     *
     * @param grid
     * @return
     */
    public int optimizeMinPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[row - 1][column - 1];
    }
}

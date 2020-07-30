package com.algorithm.dp.最小路径之和;

/**
 * @author Ernest Chen
 * @date 2020/3/2.
 *
 * leetcode[64]
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {

    /**
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n) -> 优化O(1)
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * time:
     * 空间复杂度：O(1)
     *
     * @param grid
     * @return
     */
    public int minPathSum_(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        return grid[m - 1][n - 1];
    }
}

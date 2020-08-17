package com.algorithm.dp.maze.problem;

public class BarricadesMaze_version_2 {

    /**
     * 时间复杂度：O(row * col)
     *
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int countPathsOfMaze_dp(boolean[][] grid, int row, int col) {
        int[][] dp = new int[row][col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if ((i == row - 1) || (j == col - 1)) {
                    dp[i][j] = 1;
                }
                //有石头情况
                else if (grid[i][j]) {
                    dp[i][j] = 0;
                } else {
                    //是空地情况
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}

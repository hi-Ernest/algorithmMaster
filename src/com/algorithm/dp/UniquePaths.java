package com.algorithm.dp;

import java.util.Arrays;

/**
 * @author Ernest on 2020/3/2.
 */
public class UniquePaths {

    /**
     * No obstruction condition
     * <p>
     * time：O(m * n)
     * space：O(m * n)
     *
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            dp[i][n - 1] = 1;
        }

        for (int j = 0; j < dp[m - 1].length; j++) {
            dp[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }


    public int uniquePaths_(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * In the case of obstructions
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //he starting position is the obstacle and you return 0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            //initialize：The last grid appears to be an obstacle dp[i-1][0] = 0 -> No obstacle rule dp[i-1][0] = 1
            if (obstacleGrid[i][0] != 1 && dp[i - 1][0] == 1) {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < n; j++) {
            //Same as above
            if (obstacleGrid[0][j] != 1 && dp[0][j - 1] == 1) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * optimize
     */
    public int uniquePathsWithObstaclesOptimize(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }


    public static void main(String[] args) {
        int[][] dp = new int[][]{{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
            System.out.println(row[1]);
        }
    }
}

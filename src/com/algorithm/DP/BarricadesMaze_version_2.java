package com.algorithm.DP;

import java.util.Scanner;

public class BarricadesMaze_version_2 {

    /**
     * 时间复杂度：O(row * col)
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int countPathsOfMaze_dp(boolean[][] grid, int row, int col) {
        int[][] dp = new int[row][col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                //初始化情况
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

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int row = scanner.nextInt();
//        int col = scanner.nextInt();
//
//        System.out.println(row + " "+ col);
//
//        for(int i=0; i<row; i++) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//        }

    }
}

package com.algorithm.dp.机器人走迷宫;

/**
 * @author: chenhuarui
 * @date: 2021/1/4 23:39
 */
public class SumPath {
    private static int[][] grids2 = {
            {0,0,0,0,0,0,0,0},
            {0,0,-1,0,0,0,-1,0},
            {0,0,0,0,-1,0,0,0},
            {-1,0,-1,0,0,-1,0,0},
            {0,0,-1,-1,0,-1,0,0},
            {0,-1,0,0,0,-1,0,0},
            {0,0,0,0,0,0,0,0}
    };

    private static int[][] grids = {
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0}
    };

    public static int sumOfPaths() {
        int row = grids.length;
        int col = grids[0].length;
        int[][] dp = new int[row][col];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >=0; j--) {
                if (i == row - 1 || j == col - 1) {
                    dp[i][j] = 1;
                }else if (grids[i][j] == -1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(sumOfPaths());
    }
}

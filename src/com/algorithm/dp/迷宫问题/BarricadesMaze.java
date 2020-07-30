package com.algorithm.dp.迷宫问题;

public class BarricadesMaze {

    /**
     * 递归求解
     * false -> 石头
     * true -> 终点
     *
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int countPathsOfMaze(boolean[][] grid, int row, int col) {
        if (!validSquare(grid, row, col))
            return 0;
        if (isAtEnd(grid, row, col))
            return 1;
        return countPathsOfMaze(grid, row + 1, col) + countPathsOfMaze(grid, row, col + 1);
    }

    private boolean validSquare(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    private boolean isAtEnd(boolean[][] grid, int row, int col) {
        return grid[row][col];
    }

    /**
     * DP问题 ==> 时间复杂度：O(row * col)
     *
     * @param grid
     * @param row
     * @param col
     * @return
     */
    public int countPathsOfMaze_dp(boolean[][] grid, int row, int col) {
        int[][] dp = new int[row][col];

        //初始化 ==> 只有一条路径到END
        //最后一行
        for (int s = 0; s < dp[row - 1].length; s++)
            dp[row - 1][s] = 1;

        //最后一列
        for (int t = 0; t < dp.length; t++) {
            dp[t][col - 1] = 1;
        }

        //打印初始化矩阵
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        //递推 ==> 由后往前
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                //有石头情况
                if (grid[i][j]) {
                    dp[i][j] = 0;
                } else {
                    //空地
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        /**
         *  -> j
         * | [xy坐标系] ==> 打印坐标系
         * v
         * i
         */
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][0];
    }
}

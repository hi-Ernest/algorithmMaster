package com.algorithm.dp.矩阵路径;

import java.util.Arrays;

/**
 * @author: chenhuarui
 * @date: 2021/1/6 23:06
 */
public class UniquePaths {

    /**
     *
     * @param m 矩阵长有几个方格
     * @param n 矩阵宽有几个方格
     * @return
     */
    public static int uniquePathsByDP(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        //初始化
        for (int i = 0; i <= m - 1; i++) {
           dp[i][n - 1] = 1;
        }

        for (int j = 0; j <= n - 1; j++) {
            dp[m - 1][j] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }
        return dp[0][0];
    }

    /**
     * 一维数组-减少空间复杂度
     */
    public int optimize(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 数学-组合
     * 机器人总共移动的次数 S=m+n-2，
     * 向下移动的次数 D=m-1，
     * 那么 问题可以看成从 S 中取出 D 个位置的组合数量，这个问题的解为 C(S, D)。
     */
    public int uniquePaths(int m, int n) {
        //总共的移动次数
        int D = m - 1;
        // 向下的移动次数
        long ret = 1;
        int S = m + n - 2;
        for (int i = 1; i <= D; i++) {
            ret = ret * (S - D + i) / i;
        }
        return (int) ret;
    }

    public static void main(String[] args) {
        System.out.println("uniquePathsByDP :" + uniquePathsByDP(8,7));
    }

}

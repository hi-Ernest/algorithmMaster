package com.algorithm.dp.背包问题;

/**
 * @author Ernest Chen
 * @date 2021/1/18.
 */
public class Knapsack {
    private static int[] values = {
            9, 3, 4, 3
    };
    private static int[] weights = {
            8, 3, 4, 3
    };

    public static int findMaxValueByDP(int maxCapacity, int numberOfItems, int[] weights, int[] values) {
        if (maxCapacity == 0 || numberOfItems == 0) {
            return 0;
        }
        int[][] dp = new int[numberOfItems + 1][maxCapacity + 1];
        for (int i = 1; i <= numberOfItems; i++) {
            int curValue = values[i - 1], curWeight = weights[i - 1];
            for (int j = 1; j <= maxCapacity; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curWeight] + curValue);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[numberOfItems][maxCapacity];
    }

    public static void main(String[] args) {
        System.out.println(findMaxValueByDP(10, 4, weights, values));
    }
}

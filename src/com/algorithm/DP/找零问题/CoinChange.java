package com.algorithm.DP.找零问题;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; //dp[i]:表示达到i所使用的最小硬币数 默认初始化都为0

        //i = 0 不用计算
        for (int i = 1; i <= amount; i++) {
            dp[i] = 9999; //若使用 int 最大值，会溢出变成最小值
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

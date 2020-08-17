package com.algorithm.dp.change.problem;

/**
 * @author chenhuarui
 */
public class CoinChange {
    private static final int NUM_ONE_ = -1;

    public int coinChange(int[] coins, int amount) {
        //dp[i]:means the minimum number of COINS used to reach i is initialized to 0 by default
        int[] dp = new int[amount + 1];

        //i = 0 don't calculate
        for (int i = 1; i <= amount; i++) {
            //if you use an int maximum, overflow becomes a minimum
            dp[i] = 9999;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? NUM_ONE_ : dp[amount];
    }
}

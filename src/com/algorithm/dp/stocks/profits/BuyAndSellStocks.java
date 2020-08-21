package com.algorithm.dp.stocks.profits;

/**
 * @author chenhuarui
 */
public class BuyAndSellStocks {

    private static final int NUM_TWO = 2;

    /**
     * In the prescribed number of stock transactions ->  max profit: Max = {dp[n-1, {0...k}, 0]}
     *
     * @param prices  the value of each stock
     * @param tNumber number of transaction
     * @return
     */
    public int maxProfit(int[] prices, int tNumber) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        //use the greedy algorithm or I'm going to run out of memory
        if (tNumber > prices.length >> NUM_TWO) {
            return greedy(prices);
        }

        int[][][] dp = new int[prices.length][tNumber + 1][2];

        //initialize：account for the first day of buying or selling
        for (int k = 0; k <= tNumber; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        // i：the first day
        // j：do you have stock(0 or 1)
        // k：the number of trades that have been made
        for (int i = 1; i < prices.length; i++) {
            for (int k = 0; k <= tNumber; k++) {
                dp[i][k][0] = k != 0 ? Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]) : dp[i - 1][k][0];
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int k = 0; k <= tNumber; k++) {
            maxProfit = Math.max(maxProfit, dp[prices.length - 1][k][0]);
        }
        return maxProfit;
    }

    private int greedy(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}

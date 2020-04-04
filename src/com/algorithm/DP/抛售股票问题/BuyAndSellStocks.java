package com.algorithm.DP.抛售股票问题;

public class BuyAndSellStocks {

    /**
     * 在规定的买卖股票交易次数中 -> 求最大利润 Max = {dp[n-1, {0...k}, 0]}
     * @param prices 各只股票价值
     * @param tNumber 最多交易的次数
     * @return
     */
    public int maxProfit(int[] prices, int tNumber) {
        if (prices == null || prices.length == 0)
            return 0;

        //使用贪心算法 -> 不然解题Java内存不够
        if (tNumber > prices.length / 2)
            return greedy(prices);

        int[][][] dp = new int[prices.length][tNumber + 1][2];

        //初始化：把第一天买 or 卖情况交代
        for (int k = 0; k<= tNumber; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = - prices[0];
        }

        // i：第i天
        // j：手上是否有股票(0 or 1)
        // k：已经交易的次数
        for (int i = 1; i < prices.length; i++) {
            for (int k = 0; k <= tNumber; k++) {
                dp[i][k][0] = k!=0 ? Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]) : dp[i - 1][k][0];
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
            }
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int k = 0; k <= tNumber; k++)
            maxProfit = Math.max(maxProfit, dp[prices.length - 1][k][0]);

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

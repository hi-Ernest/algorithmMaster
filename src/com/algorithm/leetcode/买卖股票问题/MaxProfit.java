package com.algorithm.leetcode.买卖股票问题;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Ernest Chen
 * @date 2021/2/2.
 */
public class MaxProfit {
    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param prices 股票价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            }else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }

    public int maxProfitV2(int[] prices) {
        int totalProfit  = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] > buyPrice) {
                totalProfit += prices[i] - buyPrice;
                buyPrice = prices[i+1];
            }else {
                buyPrice = prices[i];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4};
        System.out.println(new MaxProfit().maxProfit(prices));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        concurrentHashMap.put();
    }
}

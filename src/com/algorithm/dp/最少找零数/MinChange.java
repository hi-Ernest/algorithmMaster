package com.algorithm.dp.最少找零数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chenhuarui
 * @date: 2021/1/3 17:41
 */
public class MinChange {
    private static int[] coins = {1,2,5};
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int exchangeByRecursive(int amount, int[] coins) {
        //终止条件
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
           int subMin = exchangeByRecursive(amount - coins[i], coins);
           if (subMin == -1) {
               continue;
           }
           result = Math.min(result,subMin + 1);
        }
        //无解
        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }

    public static int exchangeByMemory(int amount, int[] coins) {
        if (map.get(amount) != null) {
            return map.get(amount);
        }

        //零钱已经花光
        if (amount == 0) {
            return 0;
        }

        //不符合规则
        if (amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int subMin = exchangeByMemory(amount - coins[i], coins);
            if (subMin == -1) {
                continue;
            }
            result = Math.min(subMin + 1, result);
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        map.put(amount, result);
        return result;
    }

    public static int exchangeByDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        for (int k = 0; k < dp.length; k++) {
            dp[k] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
               if (i >= coins[j]) {
                   dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
               }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("exchangeByDP: " + exchangeByDP(11, coins));
    }
}

package com.algorithm.dp.斐波拉契;

/**
 * @author: chenhuarui
 * @date: 2021/1/6 00:06
 */
public class CowNums {
    private static int NUM4 = 4;

    public static int calculateCowNums(int n) {
        if (n <= NUM4) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int k = 0; k <= NUM4; k++) {
            dp[k] = k;
        }
        for (int i = 5; i <= n; i++) {
            dp [i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(calculateCowNums(6));
    }
}

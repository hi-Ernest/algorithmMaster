package com.algorithm.dp.fibonacci;

/**
 * @author chenhuarui
 */
public class Fibonacci {

    /**
     * recursive
     *
     * @param n
     * @return
     */
    public int useRecursive(int n) {
        return n <= 1 ? n : useRecursive(n - 1) + useRecursive(n - 2);
    }

    /**
     * recursive(from top to bottom) + memorization optimization(array[])
     *  ==> recursive(change: from bottom to top) ==> DP
     *
     * @param n
     * @return
     */
    public int useDynamicProgramming(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}

package com.algorithm.dp.climb.stairs;

/**
 * @author chenhuarui
 */
public class ClimbStairs {

    private static final int NUM_TWO = 2;

    /**
     * 1.DP state definition
     * 2.DP equation
     * time：O(N)
     * space：O(N) -> O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= NUM_TWO) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * time：O(1)
     *
     * @param n
     * @return
     */
    public int climbStairsOtherVersion(int n) {
        if (n <= NUM_TWO) {
            return n;
        }

        int oneStep = 1;
        int twoStep = 2;
        int sumStep = 0;
        for (int i = 2; i < n; i++) {
            sumStep = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = sumStep;
        }
        return sumStep;
    }
}

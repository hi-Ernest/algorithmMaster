package com.algorithm.DP.爬楼梯;

public class ClimbStairs {

    /**
     * 1.DP状态定义
     * 2。DP方程
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) -> O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i=2; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    /**
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int climbStairs_version_Second(int n) {
        if (n <= 2) {
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

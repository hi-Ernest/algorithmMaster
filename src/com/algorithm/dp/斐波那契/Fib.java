package com.algorithm.dp.斐波那契;

public class Fib {

    /**
     * 1.递归
     * @param n
     * @return
     */
    public int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }

    /**
     * 递归(从上而下) + 记忆化优化(array[]) ==> 递推(改变顺序：从下而上) ==> DP
     * @param n
     * @return
     */
    public int fib_dp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}

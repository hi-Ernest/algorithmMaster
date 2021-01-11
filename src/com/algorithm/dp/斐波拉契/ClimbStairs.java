package com.algorithm.dp.斐波拉契;

/**
 * @author: chenhuarui
 * @date: 2021/1/5 22:23
 */
public class ClimbStairs {


    public static int recursive(int n) {
        if (n == 0) {
            return 0;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    private static final int NUM2 = 2;

    /**
     * 公式：dp[i] = dp[i - 1] + dp[i - 2]
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param n
     * @return
     */
    public static int climbStairsByDP(int n) {

        //边界-注意
        if (n < NUM2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int optimize(int n) {
        if (n < NUM2) {
            return n;
        }

        int res = 0;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(climbStairsByDP(4));
        System.out.println(optimize(4));
    }
}

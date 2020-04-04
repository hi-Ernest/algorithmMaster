package com.企业笔试.qianxin;

import java.util.Scanner;

/**
 * create by Ernest on 2020/3/31.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[]{2, 2, 3, 1, 5, 2};
        int[] nums = new int[]{2, 3, 1, 5, 4, 3};

//        System.out.println(getMaxPofile(n, values, nums));
//        System.out.println(knapsack_2(n, values.length, values, nums));
    }

    public static int getMaxPofile(int n, int[] values, int[] nums) {
        int[] dp = new int[n + 1];
        int len = values.length;
        for (int i = 1; i < len + 1; i++) {
            for (int j = n; j >= values[i]; j--) {
                dp[j] = Math.max(dp[n - values[i]] + nums[i], dp[j]);
            }
        }
        return dp[n];
    }

    public static int getMaxPofile(int n, int size, int[] values, int[] nums) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= size; i++) {
            int w = values[i - 1], v = nums[i - 1];

            for (int j = n; j >= 1; j--) {
                if (j >= w) {
                    dp[j] = Math.max(dp[j], dp[j - w] + v);
                }
            }
        }
        return dp[n];
    }
}

package com.qy;

import java.util.Scanner;

/**
 * create by Ernest on 2020/2/15.
 */
public class Main_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(getNumsOfPaths(m, n));

    }

    public static long getNumsOfPaths(int m, int n) {

        if (m < 0 || n <0)
            return 0;

        long[][] dp = new long[m][n];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j>=0; j--) {
                if ((i == m - 1) || (j == n - 1)) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1] + 1;
                }
            }
        }
        return dp[0][0];
    }
}

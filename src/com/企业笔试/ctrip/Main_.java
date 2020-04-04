package com.企业笔试.ctrip;

import java.util.Scanner;

/**
 * create by Ernest on 2020/4/1.
 */
public class Main_ {

    public static void main(String[] args) {
        String[] dirts = new String[]{"surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(judyOnlyTwice(dirts, str));
    }

    public static String judyOnlyTwice(String[] dirts, String str) {
        char[] w1 = str.toCharArray();
        int m = str.length();

        for (int i = 0; i < dirts.length; i++) {
            char[] w2 = dirts[i].toCharArray();
            int n = dirts[i].length();
            int[][] dp = new int[m + 1][n + 1];
            for (int k = 0; k < m + 1; k++) {
                dp[k][0] = k;
            }
            for (int j = 0; j < n + 1; j++) {
                dp[0][j] = j;
            }

            for (int t = 1; t < m + 1; t++) {
                for (int j = 1; j < n + 1; j++) {
                    if (w1[t - 1] == w2[j - 1]) {
                        dp[t][j] = dp[t - 1][j - 1];
                    }else {
                        dp[t][j] = 1 + Math.min(Math.min(dp[t - 1][j - 1], dp[t - 1][j]), dp[t][j - 1]);
                    }
                }
            }

            if (dp[m][n] <= 2) {
                return dirts[i];
            }

        }

        return "null";
    }
}

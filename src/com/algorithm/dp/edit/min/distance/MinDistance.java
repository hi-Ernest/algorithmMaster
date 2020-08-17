package com.algorithm.dp.edit.min.distance;

/**
 * @author Ernest Chen
 * @date 2020/2/6.
 *
 * <p>
 * leetcode[72]
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * <p>
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * </p>
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[word1.length() + 1]
                                [word2.length() + 1];

        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }


        for (int k = 1; k < word1.length() + 1; k++) {
            // dp[i][0] = i;
            for (int l = 1; l < word2.length() + 1; l++) {
                // dp[0][j] = j;
                if (w1[k - 1] == w2[l - 1]) {
                    dp[k][l] = dp[k - 1][l - 1];
                } else {
                    dp[k][l] = 1 + Math.min(Math.min(dp[k - 1][l - 1], dp[k - 1][l]), dp[k][l - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

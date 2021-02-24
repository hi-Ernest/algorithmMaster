package com.企业笔试.快手;

/**
 * create by Ernest on 2020/4/12.
 */
public class Main____ {

    public int GetMaxStaffs (char[][] pos) {
        int row = pos.length;
        int col = pos[0].length;
        int[][] dp = new int[row] [col];
        dp[0][0] = 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if ((i == row - 1) && pos[i][j] != '*' || (j == col - 1) && pos[i][j] != '*' ) {
                    dp[i][j] = 1;
                }else if (pos[i][j] == '*') {
                    dp[i][j] = 0;
                }else if (pos[i-1][j] == '*' || pos[i][j+1] == '*' || pos[i+1][j] == '*' || pos[i][j-1] == '*') {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j+1] + dp[i+1][j] + dp[i][j-1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'*','.','*','*','.'},{'*','.','*','*','*'},{'*','.','*','*','.'}
        };
        System.out.println(new Main____().GetMaxStaffs(chars));
    }
}

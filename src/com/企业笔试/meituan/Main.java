package com.企业笔试.meituan;

import java.util.Scanner;

/**
 * 有一个2*n的网格，有一个人位于(1,1)的位置，即左上角，他希望从左上角走到右下角，即(2,n)的位置。在每一次，他可以进行三种操作中的一种：
 *
 * 1． 向右走一格，即从(x,y)到(x,y+1);
 *
 * 2． 向上右方走一格，即，如果他在(2,y)的位置可以走到(1,y+1);
 *
 * 3． 向下右方走一格，即，如果他在(1,y)的位置可以走到(2,y+1);
 *
 *
 *
 * 问题当然不会这么简单，在这2*n的格子中，有一部分格子上有障碍物，他不能停在障碍物上，当然也不能走出网格，请问他有多少种不同的路线可以到达(2,n)。
 *
 *
 * 给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，每次操作你可以选择序列中的一个数字，让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。
 *
 * 请问众数最多出现多少次。
 *5 2
 * 3 1 3 2 5
 *
 * 3
 *
 */
public class Main {

    public static int getPathCount(boolean[][] gird, int n, int m) {
        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m-1 && i == n-1) {
                    dp[i][j] = 2;
                }
                else if (gird[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();

        boolean[][] a = new boolean[2][Integer.valueOf(n)];

        String[] input = scanner.nextLine().split("");
        String[] input2 = scanner.nextLine().split("");

//        System.out.println(Arrays.toString(input));
//        System.out.println(Arrays.toString(input2));


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i < a.length/2) {
                    if (input[j].equals("X")) {
                        a[i][j] = true;
                    }
                }else {
                    if (input2[j].equals("X")) {
                        a[i][j] = true;
                    }
                }
            }
        }

        System.out.println(getPathCount(a, 2, Integer.valueOf(n)));


//
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                System.out.print(a[i][j]+ " ");
//            }
//            System.out.println();
//        }

    }
}

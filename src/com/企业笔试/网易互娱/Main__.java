package com.企业笔试.网易互娱;

import java.util.*;

/**
 * create by Ernest on 2020/4/11.
 */
public class Main__ {

    public static String add(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return "0";
        }

        char[] nums2 = num2.toCharArray();
        char[] nums1 = num1.toCharArray();
        StringBuilder res = new StringBuilder();
        int flag = 0;

        for (int i = num2.length() - 1; i >= 0; i--) {
            if (nums1[i] == '.') {
                res.append('.');
                continue;
            }
            int tmp = nums1[i] + nums2[i] - 96 + flag;
            if (tmp >= 9) {
                res.append(tmp-9);
                flag = 1;
            }else {
                res.append(tmp);
                flag = 0;
            }
        }
        return res.reverse().toString();
    }



    public int maxBoxes(int[][] boxes) {
        int m = boxes[0].length;
        int n = boxes.length;
       int[][] dp = new int[m][n];

       int res = 1;

        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }


       int row = 1;
       int col = 1;
       while (col != 1) {
           if (boxes[row-1][col-1] == boxes[row][col]) {

           }
       }

       return res;
    }

    public static void main(String[] args) {
        char a = '0';
        char b = '0';
        System.out.println(a + b - 96);
    }





}
package com.企业笔试.sanliuling;

import java.util.Scanner;

/**
 * create by Ernest on 2020/3/27.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
    }

    public int expectValue(int[] nums) {
        int res = 0;
        int p = 0;
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                p = 1;
                v = 0;
            }else {
                res += nums[i];
            }
        }
        return 0;
    }
}

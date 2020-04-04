package com.企业笔试.shenxinfu;

import java.util.*;

/**
 * create by Ernest on 2020/3/24.
 */
public class Main_ {

    public static int circleIndex(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.println(circleIndex(Integer.valueOf(input[0]), Integer.valueOf(input[1])));
    }

}

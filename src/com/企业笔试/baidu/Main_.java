package com.企业笔试.baidu;

import java.util.*;

/**
 * create by Ernest on 2020/3/14.
 */
public class Main_ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
           map.put(sc.nextInt(), sc.nextInt());
        }

        System.out.println(maxPayNumsMonth(m, map));
    }

    public static int maxPayNumsMonth(int m, Map<Integer, Integer> map) {
        int[] dp = new int[m + 1];

        int sum = 0;
        for (int k : map.keySet()) {
            sum += map.get(k);
        }

        for (int i = 1; i <= m; i++) {
            dp[i] = 9999;
            for (int key : map.keySet()) {
                if (i >= key && map.get(key) != 0) {
                    dp[i] = Math.min(dp[i], dp[i - key] + 1);
                    map.put(key, map.get(key) - 1);
                }
            }
        }

        return sum / dp[m] + 1;
    }
}

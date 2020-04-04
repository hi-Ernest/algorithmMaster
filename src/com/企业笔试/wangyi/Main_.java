package com.企业笔试.wangyi;

import java.util.*;

/**
 * create by Ernest on 2020/3/29.
 */
public class Main_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int[] runtimes = new int[Integer.parseInt(inputs[0])];
        int[] scores = new int[Integer.parseInt(inputs[1])];

        for (int i = 0; i < Integer.parseInt(inputs[0]); i ++) {
            runtimes[i] = scanner.nextInt();
            scores[i] = scanner.nextInt();
        }

        System.out.println(maxProfile(runtimes, scores, Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));

    }

    public static int maxProfile(int[] runtimes, int[] scores, int n, int eachtime) {
        int maxProfile = 0;
        for (int i = 0; i < n; i++) {
            if (runtimes[i] != 0) {
                maxProfile = maxProfile + scores[i];
                runtimes[i] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                runtimes[j] = runtimes[j] - eachtime;
            }
        }

        return maxProfile;
    }
}

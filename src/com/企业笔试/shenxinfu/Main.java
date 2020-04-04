package com.企业笔试.shenxinfu;

import java.util.*;
/**
 * create by Ernest on 2020/3/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int len = Integer.valueOf(input[0]);
        int[] curr = new int[len];
        int[] add = new int[len];
        for (int i = 0; i < len; i++) {
            String[] input2 = scanner.nextLine().split(" ");
            curr[i] = Integer.valueOf(input2[0]);
            add[i] = Integer.valueOf(input2[1]);
        }

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(curr));
        System.out.println(Arrays.toString(add));

        System.out.println(water(curr, add, Integer.valueOf(input[1])));

    }

    public static int water(int[] curr, int[] add, int maxWater) {
        int other = 0;
        for (int i = 0; i < curr.length; i++) {
            int judy = maxWater - (curr[i] + other + add[i]);
            if (judy < 0) {
                other = Math.abs(judy);
            }
        }

        return other;
    }
}

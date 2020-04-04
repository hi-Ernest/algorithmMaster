package com.企业笔试;

import java.util.*;

/**
 * create by Ernest on 2020/2/15.
 */
public class Main_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println(countLengthOfString(nums));

    }

    public static int countLengthOfString(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!map.containsKey(temp)) {
                map.put(temp, count);
                res++;
            } else {
                if (map.get(temp) != temp) {
                    int sum = map.get(temp) + 1;
                    map.put(temp, sum);
                    res++;
                } else {
                    continue;
                }
            }
        }

        return res;
    }
}

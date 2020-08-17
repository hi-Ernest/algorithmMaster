package com.algorithm.dp.longest.sublist;

import java.util.*;

/**
 * Longest ascending subsequence
 * input: [10,9,2,5,3,7,101,18]
 * output: 4
 * explain: result = [2,3,7,101]，length = 4
 *
 * @author chenhuarui
 */
public class LengthOfLis {


    /**
     * Continuous LIS
     * time：O(N)
     * space：O(1)
     *
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cnt = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 1;
            }
        }
        return res;
    }


    /**
     * leetcode[300]
     * time：O(N^2)
     * space：O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLis(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res = 1;
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    /**
     * time：O(N * logN)
     *
     * @param nums
     * @return
     */
    public int lengthOfLisBinary(int[] nums) {
        if (nums == null | nums.length == 0) {
            return 0;
        }

        List<Integer> res = new LinkedList<>();
        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                int position = binarySearch(res, nums[i]);
                res.set(position, nums[i]);
            }

        }
        return res.size();
    }


    private int binarySearch(List<Integer> res, int target) {
        int left = 0, right = res.size() - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (res.get(mid) < target) {
                left = mid + 1;
            } else if (res.get(mid) > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
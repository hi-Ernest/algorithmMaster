package com.algorithm.DP;

import java.util.*;

public class LengthOfLIS {

    /**
     * 时间复杂度：O(N^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = 1;
        int[] dp = new int[nums.length];

        for (int i = 0; i<dp.length; i++) {
            dp[i] = 1;
        }

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

    public int lengthOfLIS_binary(int[] nums) {
        List<Integer> res = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int searchIndex = binarySearch(res);
            if (searchIndex == res.size()-1) {
                res.add(nums[i]);
            }else {
                res.remove(searchIndex);
                res.add(searchIndex, nums[i]);
            }

        }
        return res.size();
    }


    private int binarySearch(List nums) {
        int left = 0, right = nums.size() - 1;
        int mid = left + (right - left) / 2;
        return mid;
    }
}
package com.algorithm.dp.最长上升子序列;

import java.util.*;

/**
 * 最长上升子序列
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4
 */
public class LengthOfLIS {


    /**
     * 连续LIS
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
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
            if (nums[i] > nums[i-1]) {
                cnt++;
                res = Math.max(res, cnt);
            }else {
                cnt = 1;
            }
        }
        return res;
    }



    /**
     * leetcode[300]
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
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

    /**
     * 时间复杂度：O(N * logN)
     * @param nums
     * @return
     */
    public int lengthOfLIS_binary(int[] nums) {
        if (nums == null | nums.length == 0) {
            return 0;
        }

        List<Integer> res = new LinkedList<>();
        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res.get(res.size()-1)) {
                res.add(nums[i]);
            }else {
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
            }else if (res.get(mid) > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return left;
    }

//    public static void main(String[] args) {
//        System.out.println(new LengthOfLIS().lengthOfLIS_binary(new int[]{10,9,2,5,3,7}));
//    }
}
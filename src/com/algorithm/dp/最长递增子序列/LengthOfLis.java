package com.algorithm.dp.最长递增子序列;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author: chenhuarui
 * @date: 2021/1/10 17:04
 */
public class LengthOfLis {
    private int[] nums = {0,1,2,3,2,2,3};

    /**
     * 时间复杂度：O(N^2)
     */
    public int lengthOfLIS() {
        int len = nums.length;
        int[] dp = new int[len];
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        //return Arrays.stream(dp).max().orElse(0);
        return getMaxLength(dp);
    }

    private int getMaxLength(int[] dp) {
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = binarySearch(tails, len, num);
            tails[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    public int binarySearch(int[] tails, int len, int key) {
        int l = 0, h = len;
        while (l < h) {
            int mid = l + (l + h) / 2;
            if (tails[mid] == key) {
                return mid;
            }else if (tails[mid] > key) {
                h = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
}

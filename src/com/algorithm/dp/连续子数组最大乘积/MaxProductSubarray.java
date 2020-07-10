package com.algorithm.dp.连续子数组最大乘积;

/**
 * leetcode[152]
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class MaxProductSubarray {

    /**
     * 暴力 O(N^2)
     * @param nums
     * @return
     */
    public int maxProduct_violence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int cur = 1;
            for (int j = i; j < len; j++) {
                if (i == j) {
                    cur = nums[i];
                }else {
                    cur = cur * nums[j];
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        //一维表示数组的长度
        //二维：0 -正数最大值 1-负数最大值
        int[][] dp = new int[2][2];//不需要申请nums.length长数组 -> 滚动数组
        int res = dp[0][0] = dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = i % 2;
            int y = (i - 1) % 2; //滚动数组 exp：1 0 1 0...

            dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            dp[x][1] = Math.min(Math.min(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            res = Math.max(res, dp[x][0]);
        }
        return res;
    }

    /**
     * 优化
     * @param nums
     * @return
     */
    public int maxProduct_optimize(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res  = nums[0];
        int curMax = res;
        int curMin = res;

        for (int i = 1; i < nums.length; i++) {
            int tmp = curMax;
            //存在负数的情况 -> 最小数值与后面相乘可能得到最大值
            curMax = Math.max(Math.max(nums[i], nums[i] * curMax), nums[i] * curMin);
            curMin = Math.min(Math.min(nums[i], nums[i] * curMin), nums[i] * tmp);

            res = curMax > res ? curMax : res;
        }
        return res;
    }
}

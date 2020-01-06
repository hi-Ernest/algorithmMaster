package com.algorithm.DP;

public class MaxProductSubarray {

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


    public int maxProduct_version_2(int[] nums) {
        if (nums == null)
            return 0;

        int curMin;
        int curMax;
        int res =  curMin = curMax = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            curMax = curMax * num;
            curMin = curMin * num;

            curMin = Math.min(Math.min(curMax, curMin), num);
            curMax = Math.max(Math.max(curMax, curMin), num);

            res = curMax > res ? curMax : res;
        }
        return res;
    }
}

package com.algorithm.dp.数组区间;

/**
 * @author: chenhuarui
 * @date: 2021/1/7 23:21
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 2; i <= dp.length - 1; i++) {
            //条件是至少连续递增的三个数组成子区间-且等差
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        //dp[i]中存储每个以i为尾的子区间个数
        //需要累加才是总共的子区间数
        int res = 0;
        for (int cnt : dp) {
            res += cnt;
        }
        return res;
    }

}

package com.algorithm.dp.斐波拉契;


/**
 * @author: chenhuarui
 * @date: 2021/1/5 23:06
 */
public class Rob {
    private static int[] nums = {2,7,9,3,1};

    /**
     * leetcode198. 打家劫舍
     * @return
     */
    public static int robByDP() {
        //边界-入参
        if (nums.length < 0) {
            return -1;
        }

        int result = 0;
        int first = nums[0];
        int second = nums[1];
        for (int i = 2; i < nums.length; i++) {
            result = Math.max(first + nums[i], second);
            first = second;
            second = result;
        }
        return result;
    }

    /**
     * 强盗在环形街区抢劫
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n -1));
    }

    public int rob(int[] nums, int first, int last) {
        int first2 = 0, second = 0;
        for (int i = first; i <= last; i++) {
            int cur = Math.max(second, first2 + nums[i]);
            first2 = second;
            second = cur;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(robByDP());
        int[] nums2 = {2,3,2};
        System.out.println(new Rob().rob(nums2));
    }
}

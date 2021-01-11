package com.algorithm.dp.数组区间;

/**
 * @author: chenhuarui
 * @date: 2021/1/7 00:08
 */
public class RangeSumQuery {

    private int[] sums;

    public RangeSumQuery(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);
        System.out.println(rangeSumQuery.sumRange(2,5));
    }
}

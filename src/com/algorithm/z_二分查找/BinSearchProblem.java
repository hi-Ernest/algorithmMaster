package com.algorithm.z_二分查找;

/**
 * @author Ernest Chen
 * @date 3/2/21.
 */
public class BinSearchProblem {

    /**
     *
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
     *
     * @param nums 递增排序数组 {0, 1, 2, 3, 5} index: 0, 1, 2, 3, 4
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //只有一个数字不存在
            if (nums[mid] == mid) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //找target的右边界下标
        //target-1 不需要一定是比target小1，而可看成将target小1的数插入该数组哪个位置 = 靠近target的最左侧下标
        //{5, 7, 7, 8, 8, 10} target = 8
        //getIndex4target(nums, target) -> index：5
        //getIndex4target(nums, target - 1) -> index：3
        return getIndex4target(nums, target) - getIndex4target(nums, target - 1);
    }

    public int getIndex4target(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}

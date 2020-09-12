package com.algorithm.leetcode.二分查找;

/**
 * @author chenhuarui
 */
public class BinarySearch {

    /**
     * time:o(logN)
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

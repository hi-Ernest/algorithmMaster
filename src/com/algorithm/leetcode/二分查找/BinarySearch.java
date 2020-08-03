package com.algorithm.leetcode.二分查找;

public class BinarySearch {

    /**
     * time:o(logN)
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            //优化-溢出
            //int mid = (left + right)/2;
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

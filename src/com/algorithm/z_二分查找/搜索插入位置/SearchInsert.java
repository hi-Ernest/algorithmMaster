package com.algorithm.z_二分查找.搜索插入位置;

/**
 * @author Ernest Chen
 * @date 3/10/21 7:31 PM.
 */
public class SearchInsert {

    /**
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param nums 已排好序的数组
     * @param target 待插入的数值
     * @return 返回数值插入数组的正确位置
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        //关键 边界
        if (len == 0) {
            return 0;
        }
        //关键 边界
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                //关键 边界
                right = mid;
            }else {
                left = mid - 1;
            }
        }
        return left;
    }
}

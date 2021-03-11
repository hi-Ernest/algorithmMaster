package com.algorithm.z_快排问题.数组排成最小的数;

/**
 * @author Ernest Chen
 * @date 3/8/21 11:41 PM.
 */
public class MinNumber {

    /**
     * 排序（使用快排）+ 变种（修改比较条件）
     * @param nums 输入数组
     * @return 返回组成最小的数
     */
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        quickSort(str, 0, str.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }

    public void quickSort(String[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = getPartition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    public int getPartition(String[] nums, int left, int right) {
        int i = left;
        String sentry = nums[right];
        for (int j = left; j <= right; j++) {
            //关键：修改比较条件
            if ((sentry + nums[j]).compareTo((nums[j] + sentry)) > 0) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(String[] nums, int left, int right) {
        String tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

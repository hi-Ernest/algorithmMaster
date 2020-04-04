package com.algorithm.剑指offer.数字在排序数组出现的次数;

import java.util.Arrays;

/**
 * create by Ernest on 2020/3/9.
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {

    public int getNumberOfK(int[] array, int k) {
        //数组有序 -> 二分查找
        int index = Arrays.binarySearch(array, k);

        if (index < 0) {
            return 0;
        }

        int cnt = 1;
        //一分为二
        for (int i = index + 1; i < array.length && array[i] == k; i++) {
            cnt++;
        }

        for (int i = index-1; i >= 0 && array[i] == k; i--) {
            cnt++;
        }
        return cnt;
    }

    /**
     * 库函数 -> 可替换自己写的二分查找
     * @param array
     * @param k
     * @return
     */
    public int binarySearch(int[] array, int k) {
        int left = 0, right = array.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            }else if (array[mid] < k) {
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return res;
    }


    /**
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        if (array == null || array.length <= 0) {
            return count;
        }

        int index = 0;
        //遍历数组
        while (index != array.length) {
            if (k == array[index]) {
                count++;
            }
            index++;
        }
        return count;
    }
}

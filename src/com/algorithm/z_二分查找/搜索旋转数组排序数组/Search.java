package com.algorithm.z_二分查找.搜索旋转数组排序数组;

/**
 * @author Ernest Chen
 * @date 3/10/21 10:40 AM.
 */
public class Search {

    /**
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * @param a   待查询的数组
     * @param key 需要查询的key数值
     * @return 返回该key数值在数组的位置
     */
    public int search(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] >= a[left]) {
                if (key >= a[left] && key < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (a[mid] < a[left]) {
                if (key > a[mid] && key <= a[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

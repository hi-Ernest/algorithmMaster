package com.algorithm.z_排序.ON2;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/16/21.
 */
public class InsertSort {

    /**
     * 时间复杂度：O(N^2)
     * 最好时间复杂度: O(N)（已经排好序[1,2,3,4,5]，注意！！[是从尾到头遍历已排序的数据]）
     * 最坏时间复杂度: O(N^2)（排好序倒序[5,4,3,2,1]，相当于每次在数组第一个位置进行插入操作（时间复杂度O(N)，又需要执行N次这样插入）
     *
     * 分两个区间：已排序区间 + 未排序区间
     * 排序操作 = 比较 + 移动
     * 属于稳定性算法（待排序前数组中相同元素，排序后原有相同元素先后次序不变）
     * @param a 待排序的数组
     */
    public static void insertSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int value = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                }else {
                    break;
                }
                a[j] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }
}

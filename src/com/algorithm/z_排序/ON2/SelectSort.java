package com.algorithm.z_排序.ON2;

/**
 * @author Ernest Chen
 * @date 2/16/21.
 */
public class SelectSort {

    /**
     * 最好-最坏-平均的时间复杂度：O(N^2)
     * 不是稳定算法（ex：{5, 3, 4, 5, 2}）第一次找到min = 2 交换则相同数值5的顺序的数值次序倒乱
     *
     * @param a 待排序的数组
     */
    public void selectSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                swap(i, minIndex, a);
            }
        }
    }

    private void swap(int i, int j, int[] a) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

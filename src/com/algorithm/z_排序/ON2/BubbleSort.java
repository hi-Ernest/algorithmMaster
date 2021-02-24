package com.algorithm.z_排序.ON2;

/**
 * @author Ernest Chen
 * @date 2/16/21.
 */
public class BubbleSort {

    public static int swapCount = 0;

    /**
     * 时间复杂度：O(N^2)
     * 最好时间复杂度: O(N)（已经排好序[1,2,3,4,5]，只需要一次冒泡）
     * 最坏时间复杂度: O(N^2)（排好序倒序[5,4,3,2,1]）
     * 平均时间复杂度："有序度"和"逆序度"和"满序度"[n*(n+1)/2]
     *
     * 排序操作 = 比较 + 交换
     * 属于稳定性算法（待排序前数组中相同元素，排序后原有相同元素先后次序不变）
     * @param a 待排序的数组
     */
    public static void bubbleSort(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int len = a.length;
        for (int i = 0; i < len; i++) {
            boolean isSwap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    isSwap = true;
                    swapCount++;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 5, 6, 3, 2, 1};
        bubbleSort(array);
        System.out.println(BubbleSort.swapCount);

    }
}

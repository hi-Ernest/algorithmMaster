package com.algorithm.z_排序.ONlogN;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/16/21.
 */
public class MergeSort {

    /**
     * 时间复杂度：O(N * logN)
     * 归并排序的执行效率与要排序的原始数组的有序程度无关
     * 所以其时间复杂度是非常稳定的，不管是最好情况、最坏情况，还是平均情况，时间复杂度都是 O(N * logN)。
     *
     * 空间复杂度: O(N)
     *
     * 属于稳定性算法（待排序前数组中相同元素，排序后原有相同元素先后次序不变）
     * @param array 待排序的数组
     */
    public void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        //创建临时数组存储
        //0...p <- (s + q - 1)/2
        //p+1...q
        //int mid = (l + r - 1) / 2;
        int mid = l + (r - l) / 2;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        //merge(array, 0, array.length - 1, mid);
        mergeBySentry(array, 0, array.length - 1, mid);
    }

    public void merge(int[] array, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        //左右指针
        int i = left;
        int j = mid + 1;
        int k = 0;
        //双指针来依次比较并填充到临时数组中
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }

        //将左/右剩余的元素填充到临时数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        //将临时数组中数据填充到原数组
        k = 0;
        while (left <= right) {
            array[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 8, 3, 9, 7, 1, 2, 5};
        new MergeSort().mergeSort(arr);
    }

    /**
     * 使用哨兵 合并
     * @param array 待排序的数组
     * @param left 左边指针
     * @param right 数组右边指针
     * @param mid 数组中间元素
     */
    public static void mergeBySentry(int[] array, int left, int right, int mid) {
        //左边数组包括了mid 需要在之前的len（mid - left + 1）上 + 1
        //增加一个数组位置 - 用于存放哨兵
        int[] leftArray = new int[mid - left + 2];
        //右边数组不包括mid 所以len（right - mid）上 + 1
        int[] rightArray = new int[right - mid + 1];

        //赋值
        for (int i = 0; i <= mid - left; i++) {
            leftArray[i] = array[left + i];
        }
        leftArray[mid - left + 1] = Integer.MAX_VALUE;

        for (int j = 0; j < right - mid; j++) {
            rightArray[j] = array[mid + j + 1];
        }
        rightArray[right - mid] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = left;
        //控制接收完数组中所需要元素，可保证不将哨兵添加入数组array
        while (k <= right) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            }else {
                array[k++] = rightArray[j++];
            }
        }
    }
}

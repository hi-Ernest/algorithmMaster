package com.algorithm.z_排序.ONlogN;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/16/21.
 */
public class QuickSort {

    /**
     * 时间复杂度：O(N * logN)
     * 最坏时间复杂度：O(O^2)
     * 我举一个比较极端的例子。如果数组中的数据原来已经是有序的了，比如 1，3，5，6，8。
     * 如果我们每次选择最后一个元素作为 pivot，那每次分区得到的两个区间都是不均等的。
     * 我们需要进行大约 n 次分区操作，才能完成快排的整个过程。每次分区我们平均要扫描大约 n/2 个元素，
     * 这种情况下，快排的时间复杂度就从 O(N * logN) 退化成了 O(n^2)。
     *
     * 空间复杂度: O(1)
     *
     * 属于不稳定性算法（稳定：待排序前数组中相同元素，排序后原有相同元素先后次序不变）
     * ex：6，8，7，6，3，5，9，4，在经过第一次分区操作之后，两个 6 的相对先后顺序就会改变
     * @param array 待排序的数组
     */
    public void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = getPartition4Big2Small(array, left, right);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    public int getPartition(int[] array, int left, int right) {
        //选定哨兵
        //遍历 + 与哨兵比较 + 交换（避免数组中整体移动O(N)）
        int i = left;
        int flag = array[right];
        for (int k = left; k <= right - 1; k++) {
            if (array[k] < flag) {
                if (k != i) {
                    swap(array, k, i);
                }
                i++;
            }
        }
        swap(array, i, right);
        System.out.println("i: " + i);
        System.out.println("排序：" + Arrays.toString(array));
        return i;
    }

    public int getPartition4Big2Small(int[] array, int left, int right) {
        //选定哨兵
        //遍历 + 与哨兵比较 + 交换（避免数组中整体移动O(N)）
        int i = left;
        int flag = array[right];
        for (int k = left; k <= right - 1; k++) {
            if (array[k] > flag) {
                if (k != i) {
                    swap(array, k, i);
                }
                i++;
            }
        }
        swap(array, i, right);
        System.out.println("i: " + i);
        System.out.println("排序：" + Arrays.toString(array));
        return i;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {11, 8, 3, 9, 7, 1, 2, 5};
        //int[] arr = {1, 3, 5, 6, 8};
        new QuickSort().quickSort(arr);
    }
}

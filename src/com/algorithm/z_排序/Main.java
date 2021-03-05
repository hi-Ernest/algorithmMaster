package com.algorithm.z_排序;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/16/21.
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {4,2,3,4,6,7};
        new Main().quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = getPartition(array, left, right);
        quickSort(array, left, partition - 1);
        quickSort(array, partition + 1, right);
    }

    public int getPartition(int[] array, int left, int right) {
        int i = left;
        int sentry = array[right];
        for (int j = left; j <= right - 1; j++) {
            if (array[j] < sentry) {
                swap(array, j, i);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}

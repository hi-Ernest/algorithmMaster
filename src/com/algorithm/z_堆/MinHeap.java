package com.algorithm.z_堆;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/20/21.
 */
public class MinHeap {

    public int findKLargest(int[] nums, int k) {
        //构建最小堆
        for (int i = 0; i < k; i++) {
            heapify4Bottom(nums, i);
        }

        //剩下元素与堆顶元素比较
        for (int j = k; j < nums.length; j++) {
            if (nums[k] > nums[0]) {
                swap(nums, k, 0);
                heapify4Top(nums, 0);
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];
    }

    //小顶堆
    public void heapify4Bottom(int[] array, int i) {
        while (i > 0 && array[i] < array[i/2]) {
            swap(array, i, i/2);
            i = i/2;
        }
    }

    public void heapify4Top(int[] array, int i) {
        while (true) {
            int maxpos = i;
            if (i * 2 < array.length && array[i * 2] < array[i]) {
                maxpos = i * 2;
            }
            if (i * 2 + 1 < array.length && array[i * 2 + 1] < array[maxpos]) {
                maxpos = i * 2 + 1;
            }
            if (maxpos == i) {
                break;
            }
            swap(array, maxpos, i);
            i = maxpos;
        }
    }


    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        new MinHeap().findKLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}

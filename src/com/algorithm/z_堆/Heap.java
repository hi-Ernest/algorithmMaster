package com.algorithm.z_堆;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/19/21.
 */
public class Heap {
    //下标=1开始存储数据
    private int[] array;
    //堆可以存储的最大数据个数
    private int n;
    //堆已经存储的数据个数
    private int count;

    public Heap() {}

    public Heap(int capacity) {
        this.array = new int[capacity + 1];
        this.n = capacity;
        this.count = 0;
    }

    public void insert(int data) {
        //堆满了
        if (count > n) {
            return;
        }
        count++;
        array[count] = data;
        int index = count;
        //自下而上的堆化
        while (index > 0 && array[index] > array[index / 2]) {
            //交换父子节点value
            swap(array, index, index / 2);
            index = index / 2;
        }
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        array[1] = array[count];
        count--;
        heapify(array, n, 1);
    }

    /**
     * 自上而下的堆化
     * @param array 输入数组
     * @param n 数组中元素数量
     * @param i 对下标为i的元素堆化，交换到合适的位置
     */
    public void heapify(int[] array, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && array[i * 2] > array[i]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && array[i * 2 + 1] > array[maxPos]) {
                maxPos = i * 2 + 1;
            }
            //说明array[i] >= array[i * 2] && array[i] >= array[i * 2 + 1]
            //退出循环
            if (maxPos == i) {
                break;
            }
            swap(array, i, maxPos);
            i  = maxPos;
        }
    }

    public void buildHeap(int[] array, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    public void heapSort(int[] array) {
        int n = array.length - 1;
        buildHeap(array, n);
        //System.out.println(array[0]);
        int k = n;
        while (k >= 1) {
            //System.out.println(array[1]);
            swap(array, 1, k);
            k--;
            heapify(array, k, 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {7,5,20,16,4,1,19,13,8};
        Heap h = new Heap();
        h.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

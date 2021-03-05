package com.algorithm.剑指offer.最小的k个数;

import java.util.*;

/**
 * create by Ernest on 2020/3/11.
 */
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k) {
            return res;
        }

        Arrays.sort(input);

        int index = 0;
        while (index < k) {
            res.add(input[index]);
            index++;
        }
        return res;
    }

    /**
     * 使用堆数据结构 - 最大堆（超过k个则pop出根节点（去掉最大的数）则保留堆中为最小的k个数）
     *
     * @param arr 输入的数组
     * @param k k个数
     * @return 返回最小的k个数
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        //构建大根堆
        Queue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        //遍历数组
        for (int item : arr) {
            //head.size < k 或者 item < heap.peek（小于堆顶元素）
            if (heap.isEmpty() || heap.size() < k || item < heap.peek()) {
                heap.offer(item);
            }
            //head.size > k，否则pop出堆顶最大元素
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] res;

    /**
     * 第一次需要需要遍历整个数组 先找到一个下标 partition 再与k比较大小
     * 每次调用 partition 遍历的元素数目都是上一次遍历的 1/2
     * 因此时间复杂度是 N + N/2 + N/4 + ... + 1 = 2N, 因此时间复杂度是 O(N)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers4QuickSort(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSort(int[] arr, int left, int right, int k) {
        int p = getPartition(arr, left, right);
        if (p == k) {
            res = new int[k + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = arr[i];
            }
            return res;
            //int[] res = Arrays.copyOf(arr, p + 1);
            //return res;
        }
        return p > k ? quickSort(arr, left, p - 1, k) : quickSort(arr, p + 1, right, k);
    }

    public int getPartition(int[] arr, int left, int right) {
        int i = left;
        int sentry = arr[right];
        for (int k = left; k <= right - 1; k++) {
            if (arr[k] < sentry) {
                swap(arr, k, i);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        GetLeastNumbers gl = new GetLeastNumbers();
//        System.out.println(Arrays.toString(
//                gl.getLeastNumbers4QuickSort(new int[]{3,2,1,4,5}, 2)
//        ));

        int [] a = new int[20];
        for (int i=0; i<a.length; i++) {
            Random random = new Random();
            a[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(
                gl.getLeastNumbers4QuickSort(a, 6)
        ));
    }





}

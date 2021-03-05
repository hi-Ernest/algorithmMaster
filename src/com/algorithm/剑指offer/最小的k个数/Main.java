package com.algorithm.剑指offer.最小的k个数;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 3/3/21.
 */
public class Main {

    public int[] smallestK(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        return getKNums4Min(arr, 0, arr.length - 1, k - 1);
    }

    public int[] getKNums4Min(int[] arr, int left, int right, int k) {
        int partition = getPartition(arr, left, right);
        if (partition == k) {
            int[] res = new int[k + 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = arr[i];
            }
            return res;
        }
        return partition < k ? getKNums4Min(arr, partition + 1, right, k)
                : getKNums4Min(arr, left, partition - 1, k);
    }

    public int getPartition(int[] arr, int left, int right) {
        int i = left;
        int sentry = arr[right];
        for (int j = left; j <= right - 1; j++) {
            if (arr[left] < sentry) {
                swap(arr, i, j);
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
        Main gl = new Main();
//        System.out.println(Arrays.toString(
//                gl.getLeastNumbers4QuickSort(new int[]{3,2,1,4,5}, 2)
//        ));

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);

//        deque.addLast(1);
//        deque.addLast(2);
//        deque.addLast(3);
        System.out.println(deque);

        System.out.println(deque.pop());
        System.out.println(deque.pop());


        //优先队列 -> 完全二叉树：小顶堆
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> queue2 = new LinkedList<>();

        queue2.offer(null);
        queue2.add(null);
        queue2.poll();
        Map<Integer, Integer> map = new HashMap<>();
//        map.put(2,2);
//        Vector<Integer> vector = new Vector<>();
//        vector.add(23);
//        vector.remove(23);

//        Stack<Integer> stack = new Stack<>();
//        stack.push(88);
//        stack.pop();
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(7);
//        arrayList.remove(7);

//        int [] a = new int[5];
//        for (int i=0; i<a.length; i++) {
//            Random random = new Random();
//            a[i] = random.nextInt(100);
//            queue.offer(a[i]);
//        }
//
//        System.out.println(Arrays.toString(a));
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        int[] arr = {1,3,5,7,2,4,6,8};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(
//                gl.smallestK(arr, 4)
//        ));
    }
}

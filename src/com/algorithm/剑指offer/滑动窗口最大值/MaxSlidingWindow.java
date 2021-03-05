package com.algorithm.剑指offer.滑动窗口最大值;

/**
 * @author Ernest Chen
 * @date 3/3/21 11:49 PM.
 */
import java.util.*;
public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(k, (e1, e2) -> e2 - e1);
        //需要移动和记录
        int left = 0;
        int right = k - 1;
        for (int i = left; i <= right; i++) {
            queue.offer(nums[i]);
        }

        int[] res = new int[nums.length - k + 1];
        int start = 0;
        int index = 1;
        for (int end = k - 1; end < nums.length - 1; end++) {
            queue.remove(nums[start]);
            queue.offer(nums[end + 1]);
            res[index++] = queue.peek();
            start++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(
              maxSlidingWindow(arr, 3)
        ));
    }

}

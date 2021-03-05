package com.algorithm.z_排序.ON;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 3/5/21 11:22 AM.
 */
public class BucketSort {

    /**
     * 时间复杂度：O(N)
     *
     * 时间复杂度为 O(k * log k)。m 个桶排序的时间复杂度就是 O(m * k * log k)
     * 因为 k=n/m，所以整个桶排序的时间复杂度就是 O(n*log(n/m))。
     * 当桶的个数 m 接近数据个数 n 时，log(n/m) 就是一个非常小的常量
     * 这个时候桶排序的时间复杂度接近 O(n)。
     *
     * @param nums 待排序数组
     */
    public static void bucketSort(int[] nums) {
        int[] buckets = new int[50000 * 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 50000] += 1;
        }

        int k = 0;
        //依次遍历桶
        for (int i = 0; i < buckets.length; i++) {
            //每个桶装了几个元素
            for (int j = 0; j < buckets[i]; j++) {
                nums[k++] = i - 50000;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }
}

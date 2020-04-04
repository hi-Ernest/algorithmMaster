package com.algorithm.剑指offer.连续子数组的最大和;

/**
 * create by Ernest on 2020/3/11.
 *
 * 的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {

    /**
     * 动态规划 DP O(N)
     * @param array
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        if (array.length < 1 || array == null) {
            return array[0];
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
            max = Math.max(max, array[i]);
        }
        return max;
    }

}

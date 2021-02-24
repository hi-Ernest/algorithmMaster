package com.algorithm.leetcode.合并两个有序数组;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 2/21/21.
 */
public class MergeSortNums {

    public static List<Integer> merge(int[] nums1, int[] nums2) {
        List<Integer> res  = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                res.add(nums1[i]);
                i++;
            }else {
                res.add(nums2[j]);
                j++;
            }
        }
        while (i < nums1.length) {
            res.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            res.add(nums2[j]);
            j++;
        }
        return res;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> res  = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res.add(nums1[i]);
                i++;
            }else {
                res.add(nums2[j]);
                j++;
            }
        }
        while (i < m) {
            res.add(nums1[i]);
            i++;
        }
        while (j < n) {
            res.add(nums2[j]);
            j++;
        }
        for (int k = 0; k < res.size(); k++) {
            nums1[k] = res.get(k);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,6,9,89,90};
        int[] arr2 = {0,2,7,8,67,89,100,166,889};
        System.out.println(merge(arr, arr2));
    }
}

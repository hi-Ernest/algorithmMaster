package com.algorithm.leetcode.sum.of.three.number;

import java.util.*;

/**
 * @author chenhuarui
 * leetcode[15]
 */
public class ThreeSum {

    private static final int NUM_TREE = 3;

    /**
     * three loop O(N^3)
     * map or set t:O(N^2) s:O(N)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Set<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (hashMap.containsKey(nums[j])) {
                    Integer[] arr = {nums[j], hashMap.get(nums[j]), -nums[j] - hashMap.get(nums[j])};
                    List<Integer> list = new ArrayList<>(Arrays.asList(arr));
                    hashSet.add(list);
                } else {
                    hashMap.put(-(nums[i] + nums[j]), nums[i]);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -1, -2};
        System.out.println( new ThreeSum().threeSum(nums));

    }

    /**
     * no space is needed
     */
    public List<List<Integer>> threeSumOptimize(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < NUM_TREE) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}

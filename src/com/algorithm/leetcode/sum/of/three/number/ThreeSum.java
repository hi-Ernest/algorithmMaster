package com.algorithm.leetcode.sum.of.three.number;

import java.util.*;

/**
 * @author chenhuarui
 */
public class ThreeSum {


    /**
     * tree loop O(N^3)
     * map or set t:O(N^2) s:O(N)
     *
     * @param nums
     * @return
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

    /**
     * no space is needed
     */
    public List<List<Integer>> threeSumOptimize(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
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
            int l = i + 1;
            int r = len - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}

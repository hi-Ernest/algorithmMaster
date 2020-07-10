package com.algorithm.leetcode.全排列;

import java.util.*;

/**
 * create by Ernest on 2020/4/12.
 *
 * leetcode[46]
 * ex:
 *  Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;
    }

    //回溯
    public void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }

            track.add(nums[i]);
            backTrack(nums, track);
            track.removeLast();
        }
    }
}

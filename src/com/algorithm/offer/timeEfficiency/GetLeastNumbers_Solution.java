package com.algorithm.offer.timeEfficiency;

import java.util.*;

/**
 * create by Ernest on 2020/3/11.
 */
public class GetLeastNumbers_Solution {

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



}

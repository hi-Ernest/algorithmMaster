package com.algorithm.剑指offer.数组中出现超过一半的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * create by Ernest on 2020/3/11.
 */
public class MoreThanHalfNum_Solution {

    public static int MoreThanHalfNum_Solution(int [] array) {

        if (array.length < 1 || array == null) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        int index = 1;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], index);
            }else {
                map.put(array[i], map.get(array[i])+1);
            }
            if (map.get(array[i]) > len / 2) {
                return array[i];
            }
        }
        return 0;
    }
}

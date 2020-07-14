package com.algorithm.leetcode.字符串中的第一个唯一字符_387;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ernest Chen
 * @date 2020/7/11.
 */
public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            count[c - 'a']++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j) - 'a'] == 1) {
                return j;
            }
        }
        return -1;
    }
}

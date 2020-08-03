package com.algorithm.leetcode.字符串中的第一个唯一字符_387;

/**
 * @author Ernest Chen
 * @date 2020/7/11.
 */
public class FirstUniqChar {

    private static final Integer GLOBAL_ONE = 1;

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            count[c - 'a']++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j) - 'a'] == GLOBAL_ONE) {
                return j;
            }
        }
        return -1;
    }
}

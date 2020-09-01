package com.algorithm.leetcode.字符串中的第一个唯一字符_387;

/**
 * @author Ernest Chen
 * @date 2020/7/11.
 */
public class FirstUniqChar {

    private static final Character GLOBAL_A = 'a';

    private static final Integer GLOBAL_ONE = 1;

    private static final int[] count = new int[26];

    public int firstUniqChar(String s) {
        for (char c : s.toCharArray()) {
            count[c - GLOBAL_A]++;
        }

        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j) - GLOBAL_A] == GLOBAL_ONE) {
                return j;
            }
        }
        return -1;
    }


    //refactor
    public int findFirstUniqChar(String s) {
        if (s.length() == GLOBAL_ONE) {
            return s.charAt(0);
        }

//        Map<Character, Integer> map = Arrays.asList(s.toCharArray()).stream().map()

        return -1;
    }
}

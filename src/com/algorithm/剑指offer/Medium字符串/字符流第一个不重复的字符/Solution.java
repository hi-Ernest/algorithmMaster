package com.algorithm.剑指offer.Medium字符串.字符流第一个不重复的字符;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 2020/7/11.
 */
public class Solution {

    Map<Character, Integer> map = new LinkedHashMap<>();
    List<Character> list = new LinkedList<>();

    public void insert(char ch) {
        map.put(ch, !map.containsKey(ch) ? 1 : (map.get(ch) + 1));
        list.add(ch);
    }

    public char firstAppearingOnce() {
        char c = '#';
        for (char key : list) {
            if (map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }
}

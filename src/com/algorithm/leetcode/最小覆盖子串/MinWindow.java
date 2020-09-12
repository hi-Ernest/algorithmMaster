package com.algorithm.leetcode.最小覆盖子串;

import java.util.HashMap;

/**
 * @author chenhuarui
 * @date 2020/4/13.
 */
public class MinWindow {

    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }

        int start = 0, end = 0, minlen = s.length();
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int match = 0;

        char[] chars = t.toCharArray();
        for (Character c : chars) {
            Integer num = needs.get(c);
            needs.put(c, num == null ? 1 : num + 1);
        }

        char[] chars2 = s.toCharArray();
        while (right < s.length()) {
            char rc = chars2[right];
            if (needs.containsKey(rc)) {
                Integer num = window.get(rc);
                window.put(rc, num == null ? 1 : num + 1);
                if (needs.get(rc).equals(window.get(rc))) {
                    //字符 rc 的出现次数符合要求了
                    match++;
                }
            }
            right++;

            //window 中的字符串已符合 needs 的要求了
            while (match == needs.size()) {
                if (right - left <= minlen) {
                    //更新最小字符串位置和长度
                    start = left;
                    minlen = right - left;
                    end = right;
                }
                char lc = chars2[left];
                if (needs.containsKey(lc)) {
                    Integer num = window.get(lc);
                    window.put(lc, num - 1);
                    if (window.get(lc) < needs.get(lc)) {
                        //字符 lc 出现次数不再符合要求
                        match--;
                    }
                }
                left++;
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
    }

}

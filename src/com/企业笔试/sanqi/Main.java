package com.企业笔试.sanqi;

import java.util.*;

/**
 * create by Ernest on 2020/3/3.
 *
 * 三七互娱笔试
 */
public class Main {

    /**
     * 时间复杂度：O(n)
     * @param str
     * @return
     */
    public static int maxLengthSubstring(String str) {
        int start = 0, end = 0, res = 0;
        int len = str.length();
        Set<Character> set = new HashSet<>();

        while (start < len && end < len) {
            if (set.contains(str.charAt(end))) {
                set.remove(str.charAt(start++));
            }else {
                set.add(str.charAt(end++));
                res = Math.max(res , end - start);
            }
        }
        return res;
    }
}

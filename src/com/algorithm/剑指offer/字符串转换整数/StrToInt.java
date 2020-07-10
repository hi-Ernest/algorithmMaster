package com.algorithm.剑指offer.字符串转换整数;

/**
 * create by Ernest on 2020/4/9.
 */
public class StrToInt {

    public int StrToInt(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }

        char[] chars = str.toCharArray();
        int symbol = 0;
        int sum = 0;
        if (chars[0] == '-') {
            symbol = 1;
        }
        for (int i = symbol; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }else {
                sum = sum * 10 + chars[i] - '0';
            }
        }
        return symbol == 0 ? (sum == Integer.MAX_VALUE ? 0 : sum) : (sum * -1 == Integer.MIN_VALUE ? 0 : sum);
    }
}

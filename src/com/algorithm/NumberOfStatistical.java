package com.algorithm;

public class NumberOfStatistical {

    /**
     * O(N) -> 取决有多少个1
     * 每次消除二进制最后面的1
     * 直到没有1
     * @param x
     * @return
     */
    public static int count(int x) {
        int count = 0;
        while (x != 0) {
            x = x & (x-1);
            count++;
        }
        return count;
    }

    /**
     * x % 2 -> x & 1
     * x = x/2 -> x >> 1
     * @param x
     * @return
     */
    public static int count_(int x) {
        int mask = 1;
        int count = 0;
        while (x != 0) {
           if ((x & mask) == 1) {
               count++;
           }
           x = x >> 1;
        }
        return count;
    }
}

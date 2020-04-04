package com.algorithm.力扣问题.比特数计数;

import java.util.Vector;

/**
 * create by Ernest on 2020/4/4
 *
 * leetcode[338]
 * input: num -> 0 <= i <= num
 * output(exp): [0,1,1]
 */
public class CountBits {

    /**
     * O(N)
     * @param x
     * @return
     */
    public static Vector<Integer> countBits(int x) {
        Vector<Integer> bits = new Vector<>(x+1, 0);
        bits.add(0);
        for (int i = 1; i <= x; i++) {
            bits.add(bits.get(i & (i - 1)) + 1);
        }
        return bits;
    }
}

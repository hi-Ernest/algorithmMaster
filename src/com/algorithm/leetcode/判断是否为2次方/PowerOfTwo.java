package com.algorithm.leetcode.判断是否为2次方;

/**
 * @author chenhuarui
 * leetcode[231]
 * 2的幂次方问题&比特数计数问题
 */
public class PowerOfTwo {

    public static boolean isSecondaryPower(int x) {
        return x > 0 && (x & (x - 1)) == 0;
    }

}

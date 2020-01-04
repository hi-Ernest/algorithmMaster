package com.algorithm;
import java.util.*;

/**
 * 2的幂次方问题&比特数计数问题
 */
public class PowerOfTwo {

    public static boolean isSecondaryPower(int x) {
        return x > 0 && (x & (x-1)) == 0;
    }

    /**
     * O(N)
     * input: x -> [0,x]
     * output(exp): [0,1,1]
     * @param x
     * @return
     */
    public static Vector<Integer> countBits(int x) {
        Vector<Integer> bits = new Vector<>(x+1, 0);
        bits.add(0);
        for (int i=1; i<=x; i++) {
            bits.add(bits.get(i & (i-1)) + 1);
        }
        return bits;
    }
}

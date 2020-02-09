package com.algorithm;

/**
 * create by Ernest on 2020/2/7.
 */
public class PowerN {

    public double power(double a, int n) {
        if (n == 0)
            return 1;

        double res = 1, tmp = a;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= tmp;
            }
            n >>= 1;
            tmp *= tmp;
        }
        return res;
    }
}

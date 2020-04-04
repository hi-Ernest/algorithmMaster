package com.algorithm.剑指offer.数值的整数次方;

/**
 * create by Ernest on 2020/2/7.
 */
public class PowerN {

    public double power(double a, int n) {
        if (n < 0) {
            if (a == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -n;
        }

        if (n == 0) {
            return 1;
        }

        double res = 1, tmp = a;
        while (n != 0) {
            //相当于 n % 2 == 1
            if ((n & 1) == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n >>= 1;
        }
        return n >= 0 ? res : (1 / res);
    }
}

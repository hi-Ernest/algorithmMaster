package com.algorithm;

public class Sqrt {

    //1.二分法
    public static double sqrt(double x, double e) {
        if (x == 1 || x == 0) return x;
        double l = 0, r = x;
        double res = 0;

        while (l <= r) {
            double m = l + (r-l)/2;
            if (m == x/m) {
                return m;
            }else if (m > x/m) {
                r = m - 1;
            }else {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }

    //2.牛顿迭代法
    public static int sqrt_(int x) {
        int res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return res;
    }
}

package com.algorithm.leetcode.实现平方根;

/**
 * @author chenhuarui
 */
public class Sqrt {

    /**
     * 二分法
     */
    public static double sqrt(double x) {
        if (x == 1 || x == 0) {
            return x;
        }

        double left = 0, right = x;
        double res = 0;

        while (left <= right) {
            double mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            }else if (mid > x / mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     */
    public static int sqrtOptimize(int x) {
        int res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return res;
    }
}

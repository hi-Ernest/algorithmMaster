package com.algorithm.offer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * create by Ernest on 2020/2/23.
 *
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 动态规划
 */
public class CutRope {

    public static int cutRope(int target) {
        if (target < 2) {
            return 0;
        }else if (target == 2) {
            return 1;
        }else if (target == 3) {
            return 2;
        }

        int a = 0, b = 0, maxValue = 2;
        if (target % 3 == 0) {
            maxValue = (int) Math.pow(3, target / 3);
        }else {
            a = target - 2;
            b = a % 3;

            maxValue = (int) (maxValue * Math.pow(3, a / 3));
            if (b != 0) {
                maxValue = maxValue * b;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(cutRope(n));
    }
}
package com.企业笔试.快手;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.*;
/**
 * create by Ernest on 2020/4/12.
 */
public class Main_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
    }


    public int[] GetPowerFactor(int R, int N) {
        if (R == 1) {
            return new int[]{0};
        }
        LinkedList<Integer> res = new LinkedList<>();
        int power = (int) Math.sqrt(R);
        int flag = 1;
        for (int i = 2; i < power; i++) {
            int t = (int)Math.pow(N, i);
            if (t > R) {
                flag = i - 1;
                R -= Math.pow(N, flag);
                break;
            }
        }

        res.addLast(flag);
        for (int j = flag - 1; j >= 0; j--) {
            int tmp = (int)Math.pow(N, j);
            R -= tmp;
            if (R == 0) {
                res.add(j);
                break;
            }else if (R < 0) {
                return new int[]{};
            }
            res.add(j);
        }

        int[] ress = new int[res.size()];
        int index = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            ress[index++] = res.get(i);
        }

        return ress;
    }

    public int power(int a, int n) {
        if (n < 0) {
            if (a == 0) {
                throw new RuntimeException("分母不能为0");
            }
            n = -n;
        }

        if (n == 0) {
            return 1;
        }

        int res = 1, tmp = a;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n >>= 1;
        }
        return n >= 0 ? res : (1 / res);
    }
}
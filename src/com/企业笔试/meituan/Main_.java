package com.企业笔试.meituan;

import java.util.*;

/**
 * create by Ernest on 2020/3/12.
 *
 *
 * 第一行一个数N，代表射击轮数。
 *
 * 第二行 N个数a[i]，第 i个数为a[i]。
 *
 * 1≤N≤100,000
 *
 * 1≤a[i]<998244353
 * 不难证明答案可以表示成一个最简分数 p * q -1。
 *
 * 你需要输出三个p * q -1 对 998244353取模后的结果，以此来表示偏离靶心次数为 0 , 1 , 2时的概率。
 *
 * 其中q-1是q 在模意义下的逆元，满足q-1* q = 1 mod 998244353。
 *
 * 例如1/4, 可以写成748683265，原因是4 * 748683265 % 998244353 = 1,也有且仅有x =  748683265，1 <= x < 998244353满足乘积等于1
 */
public class Main_ {

    public int[] getRes(int[] input) {


        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();


    }
}

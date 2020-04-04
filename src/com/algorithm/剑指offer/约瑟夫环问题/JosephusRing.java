package com.algorithm.剑指offer.约瑟夫环问题;

import java.util.*;

/**
 * create by Ernest on 2020/4/2.
 *
 * ex: 一群小朋友围成环坐下玩报数游戏，报到某个数字退出 -> 求最后剩下的小朋友
 */
public class JosephusRing {

    public static void main(String[] args) {
        JosephusRing josephusRing = new JosephusRing();
        int n = 6; // 0,1,2,3,4,5
        int m = 7;
        System.out.println(josephusRing.lastNumber(n, m));
    }

    private int lastNumber(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        int count = 0;
        while (list.size() != 1) {
            //判断是否符合删除的条件
            while (count < m) {
                if (!iterator.hasNext()) {
                    //or listIterator
                    iterator = list.iterator();
                }
                iterator.next();
                count++;
            }
            // 删除第m个元素
            iterator.remove();
            // 重新开始计数
            count = 0;
        }
        return list.get(0);
    }
}

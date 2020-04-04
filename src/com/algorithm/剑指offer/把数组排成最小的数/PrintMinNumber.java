package com.algorithm.剑指offer.把数组排成最小的数;


import java.util.*;

/**
 * create by Ernest on 2020/3/11.
 */
public class PrintMinNumber {

    public String PrintMinNumber(int [] numbers) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int item : numbers) {
            list.add(item);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int item : list) {
            sb.append(item);
        }
        Map<Integer, Integer> map = new HashMap<>();
        return sb.toString();
    }
}

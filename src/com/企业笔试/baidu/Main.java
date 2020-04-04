package com.企业笔试.baidu;

import java.util.*;

/**
 * create by Ernest on 2020/3/14.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int type = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println(lastBuyNums(list));
    }

    public static int lastBuyNums(List<Integer> list) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Integer index = 1;
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), index);
            }else {
                map.put(list.get(i), map.get(list.get(i))+ 1);
            }
        }

        for (int j : map.keySet()) {
            res += map.get(j) % 2;
            res += map.get(j) / 2;
        }

        return res;
    }
}

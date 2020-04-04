package com.企业笔试.baidu;

import java.util.*;

/**
 * create by Ernest on 2020/3/14.
 */
public class Main__ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m-1; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }
    }

    public static void input(int m) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < m-1; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }

    }

    public int printWhoWinner(Map<Integer, Integer> map, int index) {
        if (!map.containsKey(index) && !map.containsValue(index)) {
            return 0;
        }
        return 0;
    }


}

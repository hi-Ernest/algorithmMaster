package com.企业笔试.meituan;

import java.util.*;

/**
 * create by Ernest on 2020/3/12.
 */
public class Main_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < Integer.valueOf(input[0]); i++) {
            list.add(scanner.nextInt());
        }

        getRes(list, Integer.valueOf(input[1]));

    }

    public static int getRes(List list, int x) {


        return 0;
    }
}

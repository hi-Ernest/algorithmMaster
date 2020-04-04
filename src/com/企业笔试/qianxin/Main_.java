package com.企业笔试.qianxin;

import java.util.Scanner;

/**
 * create by Ernest on 2020/3/31.
 */
public class Main_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] ints = new int[input.length];
        int index = 0;
        for (String i : input) {
            ints[index++] = Integer.parseInt(i);
        }

        System.out.println(judy(ints));
    }

    public static boolean judy(int[] input) {

        for (int i = 0; i < input.length-2; i++) {
            for (int j = i+1; j < input.length-1; j++) {
                for (int k = j+1; k < input.length; k++) {
                    return true;
                }
            }
        }

        return true;
    }
}
//3,4,8,5,2,6,7,1,9
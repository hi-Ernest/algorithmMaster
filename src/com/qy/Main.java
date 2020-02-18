package com.qy;

import java.util.*;

/**
 * create by Ernest on 2020/2/15.
 */
public class Main {

    /**
     * 1.10.1, 1.2.3
     * 1
     * -1
     * 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");

//        System.out.println(input[0]);
//        System.out.println(input[1]);

        System.out.println(judgTheProblem(input[0], input[1].trim()));

    }

    public static int judgTheProblem(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");

//        for (int i = 0; i < first.length; i++) {
//            System.out.println(first[i]);
//        }

        for (int i = 0; i < Math.max(first.length, second.length); i++) {
            if (Integer.parseInt(first[i]) > Integer.parseInt(second[i])) {
                return 1;
            }else if (Integer.parseInt(first[i]) < Integer.parseInt(second[i])){
                return -1;
            }
        }
        return 0;
    }
}

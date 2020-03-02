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
     *
     * @param args
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] input = scanner.nextLine().split(",");

//        System.out.println(input[0]);
//        System.out.println(input[1]);

//        System.out.println(judgTheProblem(input[0], input[1].trim()));
        System.out.println(judgTheProblem("0.1", "1.1"));

    }

    public static int judgTheProblem(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");


        for (int i = 0; i < first.length; i++) {
            System.out.println(first[i]);
        }

        System.out.println(Math.max(first.length, second.length));

        for (int i = 0; i < Math.max(first.length, second.length); i++) {
            if (Integer.parseInt(first[i]) > Integer.parseInt(second[i])) {
                return 1;
            } else if (Integer.parseInt(first[i]) < Integer.parseInt(second[i])) {
                return -1;
            }
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        for (int i = 0; i < Math.max(str1.length, str2.length); i++) {
            Integer v1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
            Integer v2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;

            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }


}

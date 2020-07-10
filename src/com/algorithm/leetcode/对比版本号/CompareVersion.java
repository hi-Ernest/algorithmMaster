package com.algorithm.leetcode.对比版本号;

/**
 * create by Ernest on 2020/2/15.
 */
public class CompareVersion {

    public static int judgTheProblem(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");

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

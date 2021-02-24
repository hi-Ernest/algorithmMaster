package com.企业笔试;

import java.util.HashMap;
import java.util.Scanner;

/**
 * create by Ernest on 2020/4/24.
 */
public class Main_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(getResult(input));
    }

    public static String getResult(String str) {
        String res = "";
        int len = str.length();
        int count = 1;

        HashMap<Character, Integer> map = new HashMap<>();
        int t = 0;
        for (int i = 0 ; i < len; i++) {
            char c = str.charAt(i);
            if (str.charAt(i) == '-') {
                char t1 = str.charAt(i-1);
                char t2 = str.charAt(i+1);
                for (char c1 : map.keySet()) {
                    int tm = str.charAt(i+2);
                    if (t1 <= c1 && c1 <= t2) {
                        if (t1 == c1) {
                            tm--;
                        }
                        map.put(c1, map.get(c1) == null ? tm : map.get(c1) + tm);
                    }
                }
                i+= 2;
                t = i;
            } else if ( 65 <= c && c >= 123) {
                if (c <= 91) {
                    c += 32;
                }
                map.put(c, map.get(c) == null ? count : map.get(c) + 1);
                t++;
            }else if (Character.isDigit((c))) {
                for (int j = t; t < i; j++) {
                    map.put(str.charAt(j), (int) c);
                }
                t = i + 1;
            }
        }

        int min = Integer.MIN_VALUE;
        char ch = 0;
        for (char c : map.keySet()) {
            if (min > map.get(c)) {
                min = map.get(c);
                ch = c;
            }else if (min == map.get(c)) {
                if (ch > c) {
                    ch = c;
                }
            }
        }
        return res + ch + min;
    }


}

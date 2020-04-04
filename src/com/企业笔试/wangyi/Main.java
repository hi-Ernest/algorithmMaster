package com.企业笔试.wangyi;

import java.util.*;

/**
 * create by Ernest on 2020/3/29.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] inputs = scanner.nextLine().split(" ");
        System.out.println(Arrays.toString(inputs));

        String res = fidSequence(n, inputs);
        System.out.println(res);
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = res.toCharArray();
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], count);
            }else {
                int tmp = map.get(chars[i]);
                map.put(chars[i], tmp + 1);
            }
        }

        for (Character key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }


    public static String fidSequence(int n, String[] inputs) {
        if (n < 0 || inputs.length > 2 || inputs.length < 2) {
            return "";
        }


        String[] subs = new String[n + 1];
        subs[0] = inputs[0];
        subs[1] = inputs[1];
        for (int i = 2; i <= n; i++) {
            subs[i] = subs[i-2] + subs[i-1];
        }
        return subs[n-1];
    }
}

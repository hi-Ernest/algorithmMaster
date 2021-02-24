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

    public static String PrintMinNumber2(int [] numbers) {
        if (numbers == null || numbers.length ==0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum1 = Integer.parseInt(numbers[i] + "" + numbers[j]);
                int sum2 = Integer.parseInt(numbers[j] + "" + numbers[i]);
                if (sum1 > sum2) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int item : numbers) {
            res.append(item);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1,4,2};
        System.out.println(PrintMinNumber2(nums));

        LinkedHashMap linkedHashMap = new LinkedHashMap();
    }
}

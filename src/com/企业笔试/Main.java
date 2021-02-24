package com.企业笔试;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * create by Ernest on 2020/4/24.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        for (int i =0; i < n; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j <input.length; j++) {
                temp.add(Integer.valueOf(input[j]));
            }
            list.add(temp);
        }

        System.out.println(countMax(list));
    }

    public static int countMax(LinkedList<LinkedList<Integer>> list) {
        int max1 = list.get(0).get(0);
        int max2 = list.get(0).get(1);
        int res = Integer.MIN_VALUE;

        int len1 = list.size();

        for (int i = 0; i < len1 - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < len1; j++) {
                if (count == 1) {
                    if (list.get(j).get(0) >= list.get(i).get(0)
                            && list.get(j).get(0) < list.get(i).get(1)
                            && list.get(j).get(1) >= list.get(i).get(0)) {
                        count++;
                        max1 = Math.max(list.get(i).get(0), list.get(j).get(0));
                        max2 = Math.min(list.get(i).get(1), list.get(j).get(1));
                    }
                }else {
                    if (list.get(j).get(0) >= max1
                            && list.get(j).get(0) < max2
                            && list.get(j).get(1) >= max1) {
                        count++;
                        max1 = Math.max(list.get(i).get(0), list.get(j).get(0));
                        max2 = Math.min(list.get(i).get(1), list.get(j).get(1));
                    }
                }
            }
            res = Math.max(count, res);
        }
        return res;
    }
}

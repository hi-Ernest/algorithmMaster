package com.algorithm.剑指offer.数组只出现一次的数字;
import java.util.*;

/**
 * create by Ernest on 2020/3/11.
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {

    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        int count = 1;
        while (index < array.length) {
            if (!map.containsKey(array[index])) {
                map.put(array[index], count);
            }else {
                map.put(array[index], count+1);
            }
            index++;
        }

        List<Integer> list = new ArrayList<>();
        for (int item : map.keySet()) {
            if (map.get(item) == 1) {
                list.add(item);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }


    public void findNumsAppearOnce_exclusive_or(int [] array,int num1[] , int num2[]) {

    }

}

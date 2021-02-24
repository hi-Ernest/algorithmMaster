package com.algorithm.剑指offer.和为S的两个数字;

/**
 * @author Ernest Chen
 * @date 2/22/21.
 */
import java.util.*;
public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left != right) {
            int tmp = array[left] + array[right];
            if (tmp < sum) {
                left++;
            }else if (tmp > sum) {
                right--;
            }else {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }
        }
        return res;
    }
}

package edu.test;

import com.algorithm.EffectiveBracktets;
import com.algorithm.ThreeSum;

import java.util.List;

public class Main {

    public static void main(String[] args) {
//        IsHasCycle list = new IsHasCycle();
//        int[] a = {1,2,3,4,5};
//        for (int i : a) {
//            list.addEnd(i);
//        }

        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, 3, -3, 2, 8, 9};

        List<List<Integer>> res = ts.threeSum(nums);
//        System.out.println(res);

        EffectiveBracktets eb = new EffectiveBracktets();
        System.out.println(eb.generateParenthesis(3));
    }
}

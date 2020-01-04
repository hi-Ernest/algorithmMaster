package edu.test;

import com.algorithm.*;

import java.util.List;
import java.util.Vector;

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

//        EffectiveBracktets eb = new EffectiveBracktets();
//        System.out.println(eb.generateParenthesis(3));


        int[] array = {10, 14, 19, 26, 27, 31, 32, 33, 42, 43};
//        BinarySearch.
//                binarySearch(array, 42);


//        System.out.println(Sqrt.sqrt(5, 1e-9) + " 333");
//        System.out.println(Sqrt.sqrt_(5));

        System.out.println(Math.sqrt(5));

        System.out.println(NumberOfStatistical.count(30));
        System.out.println(NumberOfStatistical.count_(30));


        System.out.println(PowerOfTwo.isSecondaryPower(128));
        Vector<Integer> vector = PowerOfTwo.countBits(2);
        for (Integer i : vector) {
            System.out.print(i + " ");
        }
    }
}

package com.algorithm.z_排序.ON;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 3/5/21 3:48 PM.
 */
public class CountSort {

    public static void countSort(int[] nums) {
        int max = -6666666;
        int min = 6666666;
        for (int n : nums) {
            max = Math.max(n, max);
            min = Math.min(n, min);
        }

        int[] counter = new int[max - min + 1];
        for (int n : nums) {
            counter[n - min]++;
        }

        int k =0;
        for (int i = min; i <= max; i++) {
            int cnt = counter[i - min];
            while (cnt-- > 0) {
                nums[k++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28,73,-44,-46,65,-84,-96,-24,-12,72,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }
}

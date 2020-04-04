package com.algorithm.剑指offer.数组中重复的数字;

/**
 * create by Ernest on 2020/2/25.
 *
 * ex: 如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DeleteDuplication {

    public boolean duplicate(int[] numbers,int length, int[] duplication) {

        if(numbers == null || length <= 0) {
            return false;
        }

        for(int i = 0; i < length; i++) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

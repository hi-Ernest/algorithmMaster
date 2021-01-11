package com.algorithm.start;

/**
 * @author chenhuarui
 */
public class FindRepeatedNumber {

    public static int[] duplication = new int[1];

    /**
     * time:O(N)
     * space:O(1)
     */
    public boolean findRepeatedNumber(int[] nums, int[] duplication) {
        if (nums == null || nums.length <= 0) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5};
        System.out.println(new FindRepeatedNumber().findRepeatedNumber(nums, duplication));
        System.out.println(duplication[0]);
    }
}

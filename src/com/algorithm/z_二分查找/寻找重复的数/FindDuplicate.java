package com.algorithm.z_二分查找.寻找重复的数;

/**
 * @author Ernest Chen
 * @date 3/10/21 8:11 PM.
 */
public class FindDuplicate {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     *
     * @param nums 输入乱序的数组
     * @return 一个重复的数
     */
    public int findDuplicate(int[] nums) {
        //有大前提：n + 1个整数的数组nums 其数字都在1 到 n之间
        int slow = 0;
        int quick = 0;
        slow = nums[slow];
        quick = nums[nums[quick]];
        while (slow != quick) {
            slow = nums[slow];
            quick = nums[nums[quick]];
        }
        quick = 0;
        //quick = nums[quick];
        while (quick != slow) {
            quick = nums[quick];
            slow = nums[slow];
        }
        return slow;
    }


}

package com.algorithm.剑指offer.旋转数组;

/**
 * @author Ernest Chen
 * @date 3/2/21.
 */
public class RotateArray {

    /**
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     *
     * 图解：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
     * @param numbers 旋转过后的数组 {3, 1, 3}
     * @return 最小的数
     */
    public static int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            //中间值大于最右边 说明最小数值在右边
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
                //中间数值小于等于最右边 说明在左边
            }else if(numbers[mid] < numbers[right]) {
                right = mid;
            }else {
                right--;
            }
        }
        return numbers[left];
    }



    public static void main(String[] args) {
        int[] array = {3,1,3};
        System.out.println(minArray(array));
    }
}

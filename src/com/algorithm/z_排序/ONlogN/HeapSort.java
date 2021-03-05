package com.algorithm.z_排序.ONlogN;

/**
 * @author Ernest Chen
 * @date 3/5/21 2:07 PM.
 */
public class HeapSort {

    /**
     * 比较 + 交换
     * 建堆的时间复杂度：O(N)
     * 时间复杂度都一样：O(N * logN)
     *
     * 思考与快排有什么区别？哪个好？
     *
     * @param nums 待排序的数组
     * @return 已好排序数组（从小到大）
     */
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    /**
     * 基于二叉堆中最大堆实现（抽象成完全二叉树）
     * 构建大顶堆
     * 依次将最大元素（根节点）与待排序数组最后一个元素进行交换（二叉树最深层最右边的叶子节点）
     * 每次遍历，刷新最后一个元素位置（自减1），直到与首元素相交，即完成排序
     *
     * @param nums 待排序的数组
     */
    public void heapSort(int[] nums) {
        int len = nums.length;
        //构建大顶堆 O(N)
        for (int i = len/2; i >= 0; i--) {
            heapify(nums, len, i);
        }
        for (int i = len - 1; i >= 1; i--) {
            swap(nums, 0, i);
            //i：需要堆化的元素个数 0：下标
            heapify(nums, i, 0);
        }
    }

    //自上而下的堆化
    //时间复杂度：O(N * logN)
    public void heapify(int[] nums, int len, int index) {
        //index 是父节点
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIndex = index;
        if (left < len && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            swap(nums, index, maxIndex);
            heapify(nums, len, maxIndex);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

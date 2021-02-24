package com.algorithm.z_二分查找;

/**
 * @author Ernest Chen
 * @date 2/17/21.
 */
public class BinSearch {

    /**
     * 时间复杂度：O(logN)
     *
     * @param array 有序数组
     * @param value 待查询的数值value
     * @return 返回value在数组下标
     */
    public int binarySearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == value) {
                return mid;
            }else if (array[mid] >  value) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int binarySearch4FindFirst(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >  value) {
                high = mid - 1;
            }else if (array[mid] < value) {
                low = mid + 1;
            }else {
                if (mid == 0 || array[mid - 1] != value) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int binarySearch4FindLast(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >  value) {
                high = mid - 1;
            }else if (array[mid] < value) {
                low = mid + 1;
            }else {
                if (mid == array.length - 1 || array[mid + 1] != value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值大于等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public int binarySearch4FindGreaterAndEqual(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >=  value) {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            }else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }
}

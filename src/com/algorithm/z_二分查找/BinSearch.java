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

    /**
     *
     *
     * @param a
     * @param key
     * @return
     */
    public static int getExistElement(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (a[mid] == key) {
                return mid;
            } else if(a[mid] >= a[left]) {
                if(key >= a[left] && key < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (a[mid] < a[left]){
                if(key > a[mid] && key <= a[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 题解：https://leetcode-cn.com/problems/search-rotate-array-lcci/submissions/
     * @param arr
     * @param target
     * @return
     */
    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            //返回 匹配且下标最小
            if (arr[left] == target) {
                return left;
            }
            int mid = (left + right) / 2;
            //相同 但可能有重复的元素 以left为结果
            if (arr[mid] == target) {
                right = mid;
            }else if (arr[mid] > arr[left]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if (arr[mid] < arr[left]) {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
                //arr[mid] == arr[left]
            }else {
                left++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {30, 40, 50, 60, 10, 20};

        System.out.println(getExistElement(a, 20));
    }
}

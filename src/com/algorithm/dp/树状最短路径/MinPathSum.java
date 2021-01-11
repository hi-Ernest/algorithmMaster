package com.algorithm.dp.树状最短路径;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chenhuarui
 * @date: 2021/1/3 10:12
 */
public class MinPathSum {

    private static Map<Integer, Integer> cacheMap = new HashMap<>();

    private static int[][] triangle = {
            {2,0,0,0},
            {3,4,0,0},
            {6,5,7,0},
            {4,1,8,3}
    };

    public static int getMinPathSumByRecursive(int i, int j) {
        //终止递归条件
        if (i >= triangle.length - 1) {
            return 0;
        }

        int leftSum = triangle[i + 1][j] + getMinPathSumByRecursive(i + 1, j);
        int rightSum = triangle[i + 1][j + 1] + getMinPathSumByRecursive(i + 1, j + 1);
        return Math.min(leftSum, rightSum);
    }

    public static int OptimizeRecursive(int i, int j) {

        if (cacheMap.get(i + j) != null) {
            return cacheMap.get(i + j);
        }

        //终止递归条件
        if (i > triangle.length - 1) {
            return 0;
        }

        int leftSum = triangle[i + 1][j] + getMinPathSumByRecursive(i + 1, j);
        int rightSum = triangle[i + 1][j + 1] + getMinPathSumByRecursive(i + 1, j + 1);
        int result = Math.min(leftSum, rightSum);
        cacheMap.put(i + j, result);

        return result;
    }

    public static int traverse() {
        int row = triangle.length;
        int[] min = triangle[row -1];

        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < row; j++) {
                //特殊情况
                if (triangle[i][j] == 0) {
                    continue;
                }
                min[j] = triangle[i][j] + Math.min(min[j], min[j + 1]);
            }
        }
        return min[0];
    }



    public static void main(String[] args) {
        //递归 时间复杂度O(2^n)
        int result = triangle[0][0] + getMinPathSumByRecursive(0,0);
        System.out.println("result " + result);

        int minPathSum = traverse();
        System.out.println("minPathSum :" + minPathSum);

    }
}

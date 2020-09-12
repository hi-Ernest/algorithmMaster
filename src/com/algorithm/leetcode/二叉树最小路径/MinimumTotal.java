package com.algorithm.leetcode.二叉树最小路径;

import java.util.*;

/**
 * @author chenhuarui
 * @date 2020/2/7.
 */
public class MinimumTotal {

    private int min = Integer.MAX_VALUE;
    private static final int NUM_TWO = 2;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        /**
         *  Arrays.asList(   2),
         *  Arrays.asList(  3,4),
         *  Arrays.asList( 6,5,7),
         *  Arrays.asList(4,1,8,3)
         */
        for (int i = triangle.size() - NUM_TWO; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j>= 0; j--) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                min += triangle.get(i).get(j);
                triangle.get(i).set(j, min);
            }
        }
        return triangle.get(0).get(0);
    }

    public int minimumTotalOptimize(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - NUM_TWO; i >= 0; i--) {
            for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
                dp[j] = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
            }
        }
        return dp[triangle.size()];
    }


    /**
     * 使用递归 -> 超时时间限制
     */
    private void dfs(List<List<Integer>> triangle, int i, int j, String path, int sum) {

        //terminator
        if (i == triangle.size()) {
            System.out.println(path + " sum: " + sum);
            min = Math.min(min, sum);
            return;
        }

        //process
        sum += triangle.get(i).get(j);

        //drill down
        dfs(triangle, i + 1, j, path, sum);
        dfs(triangle, i + 1, j + 1, path, sum);

        //clear states
        //note: no need to clear up the state 'path'
    }

    public static void main(String[] args) {
        MinimumTotal mt = new MinimumTotal();

        int result = mt.minimumTotal(Arrays.asList(
                Arrays.asList(   2),
                Arrays.asList(  3,4),
                Arrays.asList( 6,5,7),
                Arrays.asList(4,1,8,3)
        ));
        System.out.println(result);
    }
}

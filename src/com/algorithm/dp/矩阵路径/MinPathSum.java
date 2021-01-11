package com.algorithm.dp.矩阵路径;

/**
 * @author: chenhuarui
 * @date: 2021/1/6 09:16
 */
public class MinPathSum {

    private static int[][] grids = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };

    public static int minPathSumByDP(int[][] nums) {
        //边界
        if (nums.length == 0 || nums[0].length == 0) {
            return 0;
        }

        //初始化
        int row = nums.length - 1;
        int col = nums[0].length - 1;
        int end = nums[row][col];

        for (int i = row - 1; i >= 0;  i--) {
            nums[i][col] += end;
            end = nums[i][col];
        }

        for (int k = col - 1; k >= 0; k--) {
            nums[row][k] += end;
            end = nums[row][k];
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                nums[i][j] += Math.min(nums[i + 1][j], nums[i][j + 1]);
            }
        }
        return nums[0][0];
    }

    public static void main(String[] args) {
        System.out.println(minPathSumByDP(grids));
    }


}

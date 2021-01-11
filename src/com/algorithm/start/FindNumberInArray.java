package com.algorithm.start;

import java.util.Arrays;

/**
 * @author chenhuarui
 */
public class FindNumberInArray {
    private static int[] findTargetIndex = new int[2];

    /**
     * time:O(M + N)
     * space:O(1)
     */
    public boolean judyTargetNumberInArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;
        while (r < rows || c >= 0) {
            if (target == matrix[r][c]) {
                findTargetIndex[0] = r;
                findTargetIndex[1] = c;
                return true;
            }
            if (target > matrix[r][c]) {
                r++;
            }else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(new FindNumberInArray().judyTargetNumberInArray(matrix, 14));
        System.out.println(Arrays.toString(findTargetIndex));
    }
}

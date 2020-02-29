package com.algorithm.offer;

/**
 * create by Ernest on 2020/2/29.
 */
public class MatrixPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        //初始化为false;
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (helpJudge(matrix, i, j, rows, cols, str, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helpJudge(char[] matrix, int i, int j, int rows, int cols, char[] str, boolean[] flag, int k) {
        // 根据i和j计算位于一维数组位置
        int index = i * cols + j;
        // 递归终止条件
        if (i <0 || j < 0 || i >= rows || j >= cols || str[k] != matrix[index] || flag[index] == true) {
            return false;
        }

        // 如果 k 达到 str 末尾,说明之前全部匹配
        if (k == str.length - 1) {
            return true;
        }
        // 已经走过的道路
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加1，找不到，还原
        if (helpJudge(matrix, i + 1, j, rows, cols, str, flag, k+1) ||
                helpJudge(matrix, i - 1, j, rows, cols, str, flag, k+1) ||
                helpJudge(matrix, i, j + 1, rows, cols, str, flag, k+1) ||
                helpJudge(matrix, i, j - 1, rows, cols, str, flag, k+1)){
            return true;
        }

        // 走到这则该道不通,还原,再继续其他路径
        flag[index] = false;
        return false;
    }
}

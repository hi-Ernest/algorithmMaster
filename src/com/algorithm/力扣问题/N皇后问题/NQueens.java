package com.algorithm.力扣问题.N皇后问题;

import java.util.*;

public class NQueens {

    /**
     * leetcode[51]
     * dfs
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0)
            return res;

        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        dfs(0, n, pie, na, new HashSet<>(), res, new ArrayList<>());
        return res;
    }

    private void dfs(int level, int n, Set<Integer> pie, Set<Integer> na,
                                HashSet<Integer> col, List<List<String>> res, ArrayList<String> tempList) {
        if (level > n - 1) {
            if (tempList.size() == n) {
                List<String> result = new ArrayList<>(tempList);
                res.add(result);
            }
            return;
        }

        boolean exists = false;

        for (int j = 0; j < n; j++) {
            if (pie.contains(level + j) || na.contains(j - level) || col.contains(j)) {
                continue;
            }
            exists = true;
            pie.add(level + j);
            na.add(j - level);
            col.add(j);

            String temp = printResult(n, j);
            tempList.add(temp);
            dfs(level + 1, n, pie, na, col, res, tempList);
            pie.remove(level + j);
            na.remove(j - level);
            col.remove(j);
            tempList.remove(temp);
        }
        if (!exists) {
            return;
        }

    }

    private String printResult(int n, int j) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == j) {
                stringBuilder.append("Q");
            }else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }

    private static int count = 0;

    /**
     * leetcode[52] -> 求有几种满足条件的方案
     * 使用位运算
     * @param n
     * @return
     */
    public int solveNQueens_use_bitOperation(int n) {
        if (n < 1) {
            return 0;
        }
        dfs_bit(n, 0, 0, 0, 0);
        return count;
    }

    private void dfs_bit(int n, int row, int cols, int pie, int na) {
        if (row >= n) {
            count++;
            return;
        }

        //得到当前所有空位
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);

        while (bits != 0) {
            //取到最低位的1
            int p = bits & -bits;
            dfs_bit(n, row + 1, cols | p, (p | pie) << 1, (p | na) >> 1);
            //去掉最低位的1
            bits = bits & (bits - 1);
        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
//        System.out.println(nQueens.solveNQueens(4));
        List<List<String>> res = nQueens.solveNQueens(4);
        for (int i=0; i<res.size(); i++) {
            List<String> temp = res.get(i);
            System.out.print("[");
            for (int j =0; j<temp.size(); j++) {
                System.out.println(temp.get(j));
            }
            System.out.println("]");
            System.out.println("--------------");
        }
        nQueens.solveNQueens_use_bitOperation(4);
        System.out.println(count);
    }
}

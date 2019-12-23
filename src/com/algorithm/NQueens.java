package com.algorithm;

import java.util.*;

public class NQueens {

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

            String temp = getStr(n, j);
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

    private String getStr(int n, int j) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i<n; i++) {
            if (i == j) {
                stringBuilder.append("Q");
            }else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }

}

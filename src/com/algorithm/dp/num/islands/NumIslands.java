package com.algorithm.dp.num.islands;

/**
 * @author chenhuarui
 * @date 2020/2/6.
 */
public class NumIslands {
    private int row;
    private int column;
    private static final char NUM_ONE = '1';
    private static final char NUM_ZERO = '0';

    /**
     * dfs: O(m * n)
     *
     * @param grid
     * @return
     */
    public int solveNumIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int count = 0;
        row = grid.length;
        column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == NUM_ONE) {
                    useDfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;

    }


    private void useDfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] != NUM_ONE) {
            return;
        }
        grid[i][j] = NUM_ZERO;
        useDfs(grid, i + 1, j);
        useDfs(grid, i, j + 1);
        useDfs(grid, i - 1, j);
        useDfs(grid, i, j - 1);
    }


    private class UnionFind {
        int[] roots;
        int[] rank;
        int count;

        public UnionFind(int row, int column, int count) {
            roots = new int[row * column];
            rank = new int[row * column];
            this.count = count;

            for (int i = 0; i < row * column; i++) {
                roots[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (i != roots[i]) {
                roots[i] = find(roots[i]);
            }
            return roots[i];
        }

        public void union(int i, int j) {
            int rootX = find(i);
            int rootY = find(j);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    roots[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    roots[rootX] = rootY;
                } else {
                    roots[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }
    }

    /**
     * unionFind: O(m * NLogN)
     *
     * @param grid
     * @return
     */
    public int useUnionFind(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }

        UnionFind uf = new UnionFind(m, n, count);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                }
            }
        }
        return uf.count;
    }
}

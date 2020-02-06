package com.algorithm.DP;

/**
 * create by Ernest on 2020/2/6.
 * dfs: O(m * n)
 * unionFind: O(m * nlogn)
 */
public class NumIslands {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if (m == 0) return 0;

        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
                    count++;
                }
            }
        }
//        return count;

        UnionFind uf = new UnionFind(m, n, count);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (j + 1 < n && grid[i][j + 1] == '1')
                        uf.union(i * n + j, i * n + j + 1);
                    if (i + 1 < m && grid[i + 1][j] == '1')
                        uf.union(i * n + j, (i + 1) * n + j);
                }
            }
        }
        return uf.count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid,  i + 1, j);
        dfs(grid,  i, j + 1);
        dfs(grid,  i - 1, j);
        dfs(grid,  i, j - 1);
    }



    /**
     * use 并查集
     */
    private class UnionFind {
        int[] roots;
        int[] rank;
        int count;

        public UnionFind(int m, int n, int count) {
            roots = new int[m * n];
            rank = new int[m * n];
            this.count = count;

            for (int i = 0; i < m * n; i++) {
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
            int rootx = find(i);
            int rooty = find(j);

            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    roots[rooty] = rootx;
                }else if (rank[rootx] < rank[rooty]) {
                    roots[rootx] = rooty;
                }else {
                    roots[rooty] = rootx;
                    rank[rootx] += 1;
                }
                count--;
            }
        }
    }

}

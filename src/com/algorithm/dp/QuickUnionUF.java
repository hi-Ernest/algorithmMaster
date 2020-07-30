package com.algorithm.dp;

/**
 * create by Ernest on 2020/2/6.
 * 并查集优化
 * 1）将秩少的加入作为子节点
 * 2）路径压缩
 */
public class QuickUnionUF {
    private int[] roots;

    public QuickUnionUF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    /**
     * 路径压缩
     *
     * @param i
     * @return
     */
    private int findRoot(int i) {
        int root = i;
        while (root != roots[i]) {
            root = roots[i];
        }
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    public boolean connection(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[qroot] = proot;
    }
}

package com.algorithm.dp;

/**
 * 1）Add the ones with less rank as child nodes
 * 2）Path to the compression
 * @author Ernest on 2020/2/6.
 */
public class QuickUnionUf {

    private final int[] roots;

    public QuickUnionUf(int n) {
        roots = new int[n];
        for (int rank = 0; rank < n; rank++) {
            roots[rank] = rank;
        }
    }

    /**
     * Path to the compression
     *
     * @param rank
     * @return
     */
    private int findRoot(int rank) {
        int root = rank;
        while (root != roots[rank]) {
            root = roots[rank];
        }
        while (rank != roots[rank]) {
            int temp = roots[rank];
            roots[rank] = root;
            rank = temp;
        }
        return root;
    }

    public boolean connection(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int qRoot = findRoot(q);
        int pRoot = findRoot(p);
        roots[qRoot] = pRoot;
    }
}

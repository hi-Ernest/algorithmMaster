package com.algorithm.z_图;

/**
 * @author Ernest Chen
 * @date 2/25/21.
 */
import java.util.*;
class Graph {
    //顶点个数
    private int v;
    //邻接表
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //queue用来存储已经访问、但相连的顶点还没访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        //记录已经访问过的节点，避免重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //用来记录搜索路径
        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        while (!queue.isEmpty()) {
            //访问queue中节点
            int cur = queue.poll();
            //根据访问节点，压入该节点相连的节点们
            for (int i = 0; i < adj[cur].size(); i++) {
                int tmp = adj[cur].get(i);
                if (!visited[tmp]) {
                    //记录访问顺序
                    prev[tmp] = cur;
                    if (tmp == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[tmp] = true;
                    queue.offer(tmp);
                }
            }
        }

    }

    //prev[k] = j 即 j -> k
    //s -> t
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " -> ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.bfs(0,6);

        // 深度优先
        //graph.dfs(0, 6);

    }
}

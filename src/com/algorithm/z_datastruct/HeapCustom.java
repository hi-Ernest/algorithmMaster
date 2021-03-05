package com.algorithm.z_datastruct;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 3/3/21.
 */
public class HeapCustom {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
//        Queue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(10,(e1, e2) -> e2- e1);
        pq.add(5);
        pq.add(2);
        pq.add(1);
        pq.add(10);
        pq.add(3);
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + ", ");
        }
        System.out.println();
        System.out.println("————————————————————————");

        Deque<Integer> deque = new LinkedList<>();


    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return sentry.next;
    }
}

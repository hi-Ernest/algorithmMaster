package com.algorithm.leetcode.合并k个有序链表;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Ernest Chen
 * @date 3/3/21 7:44 PM.
 */
public class MergeKLists {

    /**
     *      cur              cur‘             cur.next
     *      +                +                +
     *      |                |                |
     *      |                |                |
     *      v                v                v
     *   dummy
     * +----------+     +---------+      +---------+      +-----------+
     * |          |     |         |      |         |      |           |
     * |          | -->+         +----> |         +----> |           |
     * +----------+     +---------+      +---------+      +-----------+
     */
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 时间复杂度：O(N * logK)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //构建优先队列 -> 最小堆
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists4DoubleMerge(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + (right - left)) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return merge2Lists(l1, l2);
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null? l2 : l1;
        return dummy.next;
    }


    public static void main(String[] args) {
//        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        //5432s1
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o2.val == o1.val) {
                    return 0;
                }else if (o2.val - o1.val < 0) {
                    return -1;
                }
                return 1;
            }
        });
        ListNode node = new ListNode(88);
        ListNode node2 = new ListNode(22);
        ListNode node22 = new ListNode(11);
        ListNode node222 = new ListNode(98);

        queue.offer(node);
        queue.offer(node2);
        queue.offer(node22);
        queue.offer(node222);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll().val);
        }
//        System.out.println(queue);
    }

}

package com.algorithm.z_链表.合并k个升序链表;

import com.algorithm.z_链表.ListNode;
import java.util.*;

/**
 * @author Ernest Chen
 * @date 3/9/21 4:07 PM.
 */
public class MergeKLists {
    /**
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(N)
     * @param lists 待排序的链表list
     * @return 已经排序好的链表头节点
     */
    public ListNode mergeKLists(ListNode[] lists) {
        //构建最小堆-优先队列
        //push进去 poll出来cur 将cur.next push
        //循环 直到
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

    /**
     * O(kn * log k)
     * O(log k)
     * 分而治之 (类似归并排序)
     *
     * @param lists 待排序的链表list
     * @return 已经排序好的链表头节点
     */
    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        //关键
        if (left == right) {
            return lists[left];
        }
        int mid = (right + left) / 2;
        ListNode l1 = mergeKLists(lists, left, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoList(l1, l2);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

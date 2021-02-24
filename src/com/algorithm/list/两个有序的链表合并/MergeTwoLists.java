package com.algorithm.list.两个有序的链表合并;

/**
 * @author Ernest Chen
 * @date 2021/1/22.
 */
public class MergeTwoLists {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param l1 一个排序链表
     * @param l2 一个排序链表
     * @return 合并之后的排序链表
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node sentry = new Node(-1);
        Node cur = sentry;
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
        return sentry.next;
    }
}

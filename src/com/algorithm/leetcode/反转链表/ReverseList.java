package com.algorithm.leetcode.反转链表;

/**
 * 反转链表
 */
public class ReverseList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = head;
        Node cur = head.next;
        Node tmp;

        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head.next = null;
        return prev;
    }


    /**
     * time:O(N)
     * space:O(1)
     *
     * @param head
     * @return
     */
    public Node reverseList_2(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = null;
        Node cur = head;
        Node tmp;

        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}

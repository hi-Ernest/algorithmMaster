package com.algorithm.offer;

/**
 * create by Ernest on 2020/2/23.
 */
public class ReverseLinkedList {

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

        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}

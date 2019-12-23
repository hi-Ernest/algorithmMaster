package com.algorithm;

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
}

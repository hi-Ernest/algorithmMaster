package com.algorithm;

public class IsHasCycle {
    private Node head = null;
    private class Node {
        public int val;
        public Node next;
        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node node) {
            this.val = val;
            this.next = node;
        }
    }

    public IsHasCycle() {
        head = new Node(0);
    }

    //head insert
    public void addFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    //tail insert
    public void addEnd(int val) {
        Node newNode = new Node(val);
        Node cur = head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        newNode = null;
    }

    /**
     * fast and slow pointer
     * @param head
     * @return
     */
    public boolean IsHasCycle(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}



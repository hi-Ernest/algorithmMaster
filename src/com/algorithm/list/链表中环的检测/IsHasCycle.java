package com.algorithm.list.链表中环的检测;

/**
 * @author Ernest Chen
 * @date 2021/1/22.
 */
public class IsHasCycle {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean isHasCycle(Node head) {
        Node fastPoint = head;
        Node slowPoint = head;
        while (fastPoint != null && fastPoint.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
            if (slowPoint == fastPoint) {
                return true;
            }
        }
        return false;
    }
}

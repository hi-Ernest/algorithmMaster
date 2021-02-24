package com.algorithm.list.反转链表;

/**
 * @author Ernest Chen
 * @date 2021/1/22.
 */
public class ReverseList {

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
     * @param head 头节点
     * @return 反转过后的头节点
     */
    public Node reverseList(Node head) {
        if (head == null) {
            return null;
        }

        Node prev = null;
        Node cur = head;
        Node temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}

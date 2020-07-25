package com.algorithm.剑指offer.链表中倒数第k个节点;

/**
 * @author Ernest Chen
 * @date 2020/7/23.
 */
public class FindKthToTail {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 最普通,但是需要记录链表长度,需要遍历两遍
     * time:O(N)
     * space:O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;
        ListNode t = head;
        while (t != null) {
            count++;
            t = t.next;
        }

        int tmp = count - k;
        int index = 0;
        while (head != null) {
            if (index == tmp) {
                return head;
            }
            head = head.next;
            index++;
        }
        return null;
    }


    /**
     * 快慢指针
     * time:O(N)
     * space:O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthToTail(ListNode head, int k) {
        ListNode quick = head, slow = head;
        for (int i = 0; i < k; i++) {
            quick = quick.next;
        }

        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }
}

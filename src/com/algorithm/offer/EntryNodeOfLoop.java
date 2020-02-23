package com.algorithm.offer;

/**
 * create by Ernest on 2020/2/23.
 */
public class EntryNodeOfLoop {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 快慢指针 + 循环
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return pHead;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = pHead;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                if (slow == fast){
                    return slow;
                }
            }
        }
        return null;
    }
}

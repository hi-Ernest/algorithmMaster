package com.algorithm.z_链表.相交链表;

import com.algorithm.z_链表.ListNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 4:46 PM.
 */
public class GetIntersectionNode {

    /**
     * 时间复杂度：O(N + M)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA  = headA;
        ListNode curB = headB;

        while (curA != curB) {
           curA = curA == null ? headB : curA.next;
           curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
}

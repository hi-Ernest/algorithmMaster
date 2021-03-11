package com.algorithm.z_链表.环形链表找入口;

import com.algorithm.z_链表.ListNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 7:32 PM.
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode p = hasCycleOfPoint(head);
        if (p == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != p) {
            cur = cur.next;
            p = p.next;
        }
        return cur;
    }

    public ListNode hasCycleOfPoint(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow) {
                return quick;
            }
        }
        return null;
    }
}

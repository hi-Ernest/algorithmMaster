package com.algorithm.z_链表.环形链表;

import com.algorithm.z_链表.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ernest Chen
 * @date 3/9/21 7:27 PM.
 */
public class HasCycle {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head 链表头节点
     * @return true/false
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public boolean hasCycle4Set(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

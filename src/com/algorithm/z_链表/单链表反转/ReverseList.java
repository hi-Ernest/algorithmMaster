package com.algorithm.z_链表.单链表反转;

import com.algorithm.z_链表.ListNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 3:47 PM.
 */
public class ReverseList {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head 链表头节点
     * @return 反转后链表头节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

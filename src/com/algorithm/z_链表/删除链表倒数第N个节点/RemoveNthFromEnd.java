package com.algorithm.z_链表.删除链表倒数第N个节点;

import com.algorithm.z_链表.ListNode;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 3/10/21 10:04 AM.
 */
public class RemoveNthFromEnd {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head 待删除链表头节点
     * @param n 删除倒数第K个节点
     * @return 已删除完成链表的头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        //关键
        dummy.next = head;
        //关键
        ListNode slow = dummy;
        ListNode quick = head;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public ListNode removeNthFromEnd4Stack(ListNode head, int n) {
        //使用栈
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return dummy.next;

    }
}

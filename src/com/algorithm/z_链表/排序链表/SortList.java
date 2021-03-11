package com.algorithm.z_链表.排序链表;

import com.algorithm.z_链表.ListNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 11:42 PM.
 */
public class SortList {

    /**
     * 时间复杂度：O(N logN)
     * 空间复杂度：O(N)
     * 归并排序（找中点-断开 + 递归 + 合并两个链表）
     * @param head 待排序链表的头节点
     * @return 已排好序链表的头节点
     */
    public ListNode sortList(ListNode head) {
        //终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //归并排序 O(N logN)
        //找中间点 并 断开
        //合并两个链表
        ListNode middleNode = getMiddleNode(head);
        ListNode rightNode = middleNode.next;
        middleNode.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);
        return mergeTwoList(left, right);
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        ListNode pre = head;
        while (quick != null && quick.next != null) {
            pre = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        return pre;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 =l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}

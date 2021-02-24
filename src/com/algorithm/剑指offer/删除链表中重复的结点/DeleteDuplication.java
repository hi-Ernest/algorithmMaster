package com.algorithm.剑指offer.删除链表中重复的结点;

/**
 * @author Ernest Chen
 * @date 2020/7/25.
 * <p>
 * 在一个排序的链表中，存在重复的结点
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //记录前置位置A 记录后置B
        //进行连接 = 删除之间结点
        ListNode sentry = new ListNode(-1);
        sentry.next = pHead;
        ListNode pre = sentry;
        ListNode cur = pHead;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        return sentry.next;
    }


    public static void main(String[] args) {
        ListNode pHead = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);

//        pHead.next = first;
//        first.next = second;

//        while (pHead != null) {
//            System.out.println(pHead.val);
//            pHead = pHead.next;
//        }

        pHead.next = second;

        while (pHead != null) {
            System.out.println(pHead.val);
            pHead = pHead.next;
        }

    }
}

package com.algorithm.删除链表倒数第N个结点;

/**
 * @author Ernest Chen
 * @date 2021/1/22.
 */
public class RemoveNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int index = 0;
        ListNode dummyNode = new ListNode(-1);
        dummyNode = head;
        int prev = count - n - 1;
        while (head != null) {
            if (index == prev) {
                break;
            }
            index++;
            head = head.next;
        }
        head.next = head.next.next;
        return dummyNode;
    }
}

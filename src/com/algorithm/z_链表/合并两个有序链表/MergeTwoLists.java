package com.algorithm.z_链表.合并两个有序链表;

import com.algorithm.z_链表.ListNode;

/**
 * @author Ernest Chen
 * @date 3/9/21 3:53 PM.
 */
public class MergeTwoLists {

    /**
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(1)
     * @param l1 待排序链表1
     * @param l2 待排序链表2
     * @return 返回合并后一条链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

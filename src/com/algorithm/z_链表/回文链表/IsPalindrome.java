package com.algorithm.z_链表.回文链表;

import com.algorithm.z_链表.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ernest Chen
 * @date 3/9/21 8:27 PM.
 */
public class IsPalindrome {

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param head 链表头节点
     * @return 是否为回文
     */
    public boolean isPalindrome(ListNode head) {

        //快慢指针 - 得到链表中值
        //链表反转
        //比较
        ListNode slow = head, quick = head;
        ListNode prev = null, cur = head;
        while (quick != null && quick.next != null) {
            cur = slow;
            slow = slow.next;
            quick = quick.next.next;
            cur.next = prev;
            prev = cur;
        }

        //得到slow -> right
        //prev是反转后的

//        ListNode next = cur.next;
//        cur.next = prev;
//        prev = cur;
//        cur = next;

        //链表为奇数的时候 quick不为空 需要slow移到链表后半部分
        if (quick != null) {
            slow = slow.next;
        }

        while (cur != null && slow != null) {
            if (cur.val != slow.val) {
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }
        return true;

    }

    public boolean isPalindrome4Array(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

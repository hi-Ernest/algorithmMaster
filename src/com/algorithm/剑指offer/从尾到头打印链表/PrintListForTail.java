package com.algorithm.剑指offer.从尾到头打印链表;

import java.util.*;

/**
 * create by Ernest on 2020/2/23.
 */
public class PrintListForTail {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> resList = new ArrayList<>();
        while (!stack.isEmpty()) {
            resList.add(stack.pop());
        }
        return resList;
    }
}

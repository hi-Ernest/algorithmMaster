package com.algorithm.start;

import java.util.*;

/**
 * @author chenhuarui
 */
public class PrintListFromTailToHead {

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> ret = new ArrayList<>();

        while (!stack.isEmpty()) {
            ret.add(stack.poll());
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(new PrintListFromTailToHead().printListFromTailToHead(listNode));
    }
}

package com.algorithm.z_链表;


import org.w3c.dom.NodeList;

/**
 * @author Ernest Chen
 * @date 2021/2/5.
 */
public class Main {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solveProblem(ListNode head) {
        //listSize(head);
        ListNode h = printList(head);
//        while (h != null) {
//            System.out.print(h.val + " ");
//            h = h.next;
//        }
        ListNode reverseNode = reverseList(h);
//                while (reverseNode != null) {
//            System.out.print(reverseNode.val + " ");
//                    reverseNode = reverseNode.next;
//        }
        return mergeTwo(head, reverseNode);
    }

    public ListNode mergeTwo(ListNode l1, ListNode l2) {


        boolean flag = true;
        int cmt = listSize(l1);
        int count = cmt / 2;
        if (cmt % 2 == 0) {
            count -= 1;
            flag = false;
        }
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;


        System.out.println("4567890");
        printList(l1);
        System.out.println();
        printList(l2);

        return sentry.next;

//        for (int i = 0; i < count; i++) {
//            cur.next = l1;
//            l1 = l1.next;
//            cur = cur.next;
//            cur.next = l2;
//            l2 = l2.next;
//            cur = cur.next;
//        }
//        cur.next = l1;
//        cur = cur.next;
//        if (!flag) {
//            cur.next = l2;
//            cur = cur.next;
//        }
//        cur.next = null;
//        return sentry.next;
    }

    public int listSize(ListNode head) {
        int cmt = 0;
        while (head != null) {
            cmt++;
            head = head.next;
        }
        return cmt;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }


    public ListNode printList(ListNode cur) {
        ListNode sentry = new ListNode(-1);
        ListNode iter = sentry;
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            iter.next = newNode;
            iter = iter.next;
            cur = cur.next;
        }
        return sentry.next;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode res =
                new Main().solveProblem(head);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
//        ListNode cur = new Main().reverseList(prev);
//        while (cur != null) {
//            System.out.print(cur.val + " ");
//            cur = cur.next;
//        }

    }
}

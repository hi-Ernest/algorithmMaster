package com.algorithm.list.两个有序的链表合并;

import com.algorithm.z_链表.Main;

/**
 * @author Ernest Chen
 * @date 2021/1/22.
 */
public class MergeTwoLists {
    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)
     * @param l1 一个排序链表
     * @param l2 一个排序链表
     * @return 合并之后的排序链表
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node sentry = new Node(-1);
        Node cur = sentry;
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
        return sentry.next;
    }

    public int listSize(Node head) {
        int cmt = 0;
        while (head != null) {
            cmt++;
            head = head.next;
        }
        return cmt;
    }

    public Node mergeTwo(Node l1, Node l2) {
        boolean flag = true;
        int cmt = listSize(l1);
        int count = cmt / 2;
        if (cmt % 2 == 0) {
            count -= 1;
            flag = false;
        }
        Node sentry = new Node(-1);
        Node cur = sentry;
        for (int i = 0; i < count; i++) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        cur.next = l1;
        cur = cur.next;
        if (!flag) {
            cur.next = l2;
            cur = cur.next;
        }
        cur.next = null;
        return sentry.next;
    }


    public Node reverseList(Node head) {
        Node prev = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node21 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
//        Node node55 = new Node(6);

        head.next = node21;
        node21.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
//        node5.next = node55;
//        node55.next = null;

//        Node node53 = new Node(6);
        Node head2 = new Node(5);
        Node node22 = new Node(4);
        Node node32 = new Node(3);
        Node node42 = new Node(2);
        Node node52 = new Node(1);

//        node53.next = head2;
        head2.next = node22;
        node22.next = node32;
        node32.next = node42;
        node42.next = node52;
        node52.next = null;


//        Node head2 = head;
//        Node prev = head;
        MergeTwoLists m = new MergeTwoLists();

//        Node tail = m.reverseList(prev);
        //m.print(head2);
        //m.print(head);
        Node res = m.mergeTwo(head, head2);
        m.print(res);

//        while (res != null) {
//            System.out.print(res.val + " ");
//            res = res.next;
//        }
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}

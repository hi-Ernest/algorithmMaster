package com.algorithm.z_队列.数组实现队列;


/**
 * @author Ernest Chen
 * @date 2/15/21.
 */
public class ListQueue {

    private class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }
    }
    //头指针
    private Node head = null;
    //尾指针
    private Node tail = null;

    public void enqueue(String item) {
        Node node = new Node(item);
        if (tail == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        String res = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return res;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

}

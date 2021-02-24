package com.algorithm.z_链表.实现LRU淘汰算法;

import java.util.Scanner;

/**
 * @author Ernest Chen
 * @date 2021/2/5.
 */
public class LRUBaseLinkedList<T> {

    private final static Integer DEFAULT_CAPACITY = 10;

    private SNode<T> headNode;

    private Integer length;

    private Integer capacity;

    public LRUBaseLinkedList() {
        headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 使用头插
     * @param data
     */
    public void add(T data) {
        //链表是否已经存在，存在则删除并插入头部，否则直接插入头部
        //删除链表中节点需要找到前一个节点
        //如果存在则直接返回前一个节点
        SNode<T> preNode = finPreNode(data);
        if (preNode != null) {
            deleteSNode(preNode);
        }else {
            if (length >= this.capacity) {
                //删除尾节点
                deleteSNode4Tail();
            }
        }
        insert2Head(data);
    }

    /**
     * 需要修正-这里定义的头节点是哨兵节点不会有val
     * @param data
     * @return
     */
    private SNode<T> findPreSNode(T data) {
        SNode<T> preNode = null;
        while (headNode != null) {
            if (headNode.val == data) {
                return preNode;
            }else {
                preNode = headNode;
                headNode = headNode.next;
            }
        }
        return preNode;
    }

    /**
     * 是否存在该节点，则返回前一个节点
     * @param data 插入的新节点
     * @return 若已存在新节点则返回该节点的前一个节点
     */
    private SNode<T> finPreNode(T data) {
        SNode<T> preNode = headNode;
        while (headNode.next != null) {
            if (data.equals(headNode.next.val)) {
                return preNode;
            }
            headNode = headNode.next;
        }
        return null;
    }

    private void deleteSNode(SNode<T> preNode) {
        preNode.next = preNode.next.next;
    }

    private void insert2Head(T newData) {
        SNode<T> newNode = new SNode<>(newData);
        SNode<T> tmpNode = headNode.next.next;
        newNode.next = tmpNode;
        headNode.next = newNode;
        length++;
    }

    private void deleteSNode4Tail() {
        SNode<T> preNode = headNode;
        if (preNode.next == null) {
            return;
        }

        while (preNode.next.next != null) {
            preNode = preNode.next;
        }
        preNode.next = null;
        length--;

    }

    private void printAll() {
        SNode node = headNode.next;
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }

    class SNode<T> {
        private T val;
        private SNode next;
        public SNode(T val) {
            this.val = val;
        }

        public SNode() {

        }
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}

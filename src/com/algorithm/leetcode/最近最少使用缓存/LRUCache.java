package com.algorithm.leetcode.最近最少使用缓存;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Ernest Chen
 * @date 2/23/21.
 */
import java.util.*;
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    //伪头和伪尾
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //O(1)的get操作
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        //如果数组 - 链表中没有 则插入新节点
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到哈希表中
            cache.put(key, newNode);
            //添加到双向链表的头部
            insert2Head(newNode);
            size++;
            //如果插入newNode，不够容量则需要删除尾节点
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        }else {
            //否则覆盖-再移动到头节点
            node.value = value;
            move2Head(node);
        }
    }

    /**
     * 插入链表头部
     * @param node 待插入的节点
     */
    public void insert2Head(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除尾节点
     * @return 已删除的尾节点
     */
    public DLinkedNode removeTail() {
        DLinkedNode delNode = tail.prev;
        removeNode(delNode);
        return delNode;
    }

    /**
     * 删除指定节点
     * @param node 待删除的节点
     */
    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将指定节点移动到双向链表的头部
     * @param node 待移动的链表节点
     */
    public void move2Head(DLinkedNode node) {
        //删除现在链表的该节点
        removeNode(node);
        //插入新的该节点到链表头部
        insert2Head(node);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
    }
}

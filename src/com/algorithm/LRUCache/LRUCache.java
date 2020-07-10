package com.algorithm.LRUCache;

import java.util.HashMap;

/**
 * create by Ernest on 2020/2/6.
 *
 * 使用hashMap + 双向链表实现 -> LRUCache
 */
public class LRUCache {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 删除指定的node
     * @param node
     */
    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.pre = head;

        node.next = headNext;
        headNext.pre = node;
    }

    /**
     * GET
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int result = node.value;
        removeNode(node);
        addToHead(node);
        return result;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                if (tail.pre != head) {
                    map.remove(tail.pre.key);
                    removeNode(tail.pre);
                }
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
        }else {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }
}

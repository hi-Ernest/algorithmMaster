package com.企业笔试;

import java.util.*;

/**
 * 双向链表 + hashMap
 *
 * 定义双向链表的节点
 */
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLastNode() {
       if (tail.prev == head) {
           return null;
       }
       Node node = tail.prev;
       removeNode(node);
       return node;
    }

    public int getSize() {
        return size;
    }
}

public class LRUCache {

    HashMap<Integer, Node> map;
    int capacity;
    DoubleList doubleList;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        doubleList = new DoubleList();
    }

    public int get(int key) {
        //不存在就返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        //存在则该节点提到链表头部并返回value
        int val = map.get(key).value;
        afterGet(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        //不存在则新建node并map.push(key, node)
        if (!map.containsKey(key)) {
            //判断是否大于容量 -> 删除尾部node 插入头部node
            if (capacity == doubleList.getSize()) {
                Node delNode = doubleList.removeLastNode();
                map.remove(delNode.key);
            }
            doubleList.addToHead(node);
            map.put(key, node);
        }
        //存在则删除旧的key node并新建node -> push 插入map头部
        //只更新value
        else {
//            doubleList.removeNode(map.get(key));
//            doubleList.addToHead(node);
            map.put(key, node);
        }

    }

    public void afterGet(int key, int value) {
        Node node = new Node(key, value);
        doubleList.removeNode(map.get(key));
        doubleList.addToHead(node);
        map.put(key, node);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        scanner.nextLine();
        LRUCache lruCache = new LRUCache(capacity);

        List<Integer> res = new LinkedList<>();

        Scanner sc =  new Scanner(System.in);

        //while(sc.hasNextLine()){
        while(sc.hasNext()){
            String c = sc.next();
            if (c.equals("p")) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                lruCache.put(a, b);
            } else {
                int a = sc.nextInt();
                System.out.println(lruCache.get(a));
//                res.add(lruCache.get(Integer.parseInt(inputs[1])));
            }
        }

        for (int i : res) {
            System.out.println(i);
        }

    }



//        String handleInput = scanner.nextLine();
//        while (handleInput != null && !handleInput.equals("")) {
//            String[] inputs = handleInput.split(" ");
//            if (inputs[0].equals("p")) {
//                lruCache.put(Integer.valueOf(inputs[1]), Integer.valueOf(inputs[2]));
//            } else {
//                System.out.println(lruCache.get(Integer.parseInt(inputs[1])));
////                res.add(lruCache.get(Integer.parseInt(inputs[1])));
//            }
//            handleInput = scanner.nextLine();
//        }

//        for (int i : res) {
//            System.out.println(i);
//        }


    public void handleInput() {
        List<String> res = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        while (nextLine != null && !nextLine.equals("")) {
            res.add(nextLine);
            nextLine = scanner.nextLine();
        }

        System.out.println("end of input string");

        for (String s : res) {
            System.out.println(s);
        }
    }

}

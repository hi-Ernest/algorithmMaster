package com.algorithm.z_队列.数组实现队列;

/**
 * @author Ernest Chen
 * @date 2/15/21.
 */
public class CircularQueue {

    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     * @param item 入队元素
     * @return true/false
     */
    public boolean enqueue(String item) {
        //队列已满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     * @return head最先进入队列
     * 的元素
     */
    public String dequeue() {
        // 如果head == tail 表示队列已空
        if (head == tail) {
            return null;
        }
        String res = items[head];
        head = (head + 1) % n;
        return res;
    }
    //队列为空
    //队列已满
    public void printAll() {
        if (0 == n) return;
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

}

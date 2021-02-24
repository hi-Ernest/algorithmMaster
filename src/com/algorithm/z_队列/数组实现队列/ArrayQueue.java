package com.algorithm.z_队列.数组实现队列;

import java.util.Arrays;

/**
 * @author Ernest Chen
 * @date 2/15/21.
 */
public class ArrayQueue {

    //底层数组
    private String[] items;
    //数组长度
    private int n = 0;
    //队头下标
    private int head = 0;
    //队尾下标
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        //如果 tail == n 表示队列已满
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    //问题: 即使数组左侧有空闲空间，也无法继续往队列中添加数据
    //待解决（对于数组来说就是数据搬移 = 每次进行出队操作相当于删除数组下标为0的数据）
    //这样出队时间复杂度O(1) -> O(N) 需要优化
    public String dequeue() {
        //如果 head == tail 表示队列已空
        if (head == tail) {
            return null;
        }
        String res = items[head];
        head++;
        return res;
    }

    public boolean enqueueOptimize(String item) {
        //数据搬移发生在队列无空余空间
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        System.out.println(arrayQueue.enqueueOptimize("1"));
        System.out.println(arrayQueue.enqueueOptimize("2"));
        System.out.println(arrayQueue.enqueueOptimize("3"));
        System.out.println(Arrays.toString(arrayQueue.items));

        System.out.println(String.format("head: %s, tail: %s", arrayQueue.head, arrayQueue.tail));

        //数组还是之前的数组，只是head指针的移动
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(String.format("head: %s, tail: %s", arrayQueue.head, arrayQueue.tail));

        System.out.println(arrayQueue.enqueueOptimize("3"));
        System.out.println(String.format("head: %s, tail: %s", arrayQueue.head, arrayQueue.tail));
        System.out.println(arrayQueue.enqueueOptimize("4"));

        System.out.println(Arrays.toString(arrayQueue.items));
    }
}

package com.algorithm.z_队列.两个队列实现一个栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ernest Chen
 * @date 2021/2/5.
 */
public class CustomQueue<T> {

    private Stack<Integer> oldStack = new Stack<>();

    private Deque<Integer> stack1;

    private Deque<Integer> stack2;

    private Queue<Integer> queue = new LinkedList<>();

    public CustomQueue() {
        stack1  = new LinkedList<>();
        stack2  = new LinkedList<>();
    }

    private void push(Integer element) {
        stack1.push(element);
    }

    private Integer pop() {
        //如果stack2为空,将stack1全部取出并push到stack2中,还是没有元素则pop则返回-1
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.poll();
        }
    }

    private Integer pop2() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.poll();
    }
}

package com.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ernest Chen
 * @date 2/14/21.
 */
public class MinStack {

    private Deque<Integer> dataStack;

    //辅助栈
    private Deque<Integer> minStack;

    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty()? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(9);
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.top());

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

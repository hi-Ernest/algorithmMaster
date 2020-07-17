package com.algorithm.剑指offer.栈的压入和弹出;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Ernest Chen
 * @date 2020/7/12.
 *
 * 判断pushA序列压入栈,出栈序列有没有可能是popA
 */
public class Solution {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0
                || pushA.length != popA.length) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        Integer startValue = popA[0];
        Integer startIndex = 0;
        while (startIndex != pushA.length) {
            stack.addLast(pushA[startIndex]);
            if (pushA[startIndex] == startValue) {
                stack.removeLast();
                break;
            }
            startIndex++;
        }

        int popAStartIndex = 1;
        startIndex++;
        while (popAStartIndex < popA.length) {
            if (popA[popAStartIndex] == stack.peekLast()) {
                stack.removeLast();
                popAStartIndex++;
            }else {
                if (startIndex < pushA.length) {
                    stack.addLast(pushA[startIndex]);
                    startIndex++;
                }else {
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println(new Solution().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0
                || popA.length == 0 || pushA.length != popA.length) return false;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        st.push(pushA[i++]);
        while(j <= popA.length-1){
            while(popA[j] != st.peek()){
                if(i == pushA.length) return false;
                st.push(pushA[i++]);
            }
            j++;
            st.pop();
        }
        return true;
    }
}

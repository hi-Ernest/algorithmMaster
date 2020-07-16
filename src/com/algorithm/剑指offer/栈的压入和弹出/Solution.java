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
        if (pushA == null || pushA.length == 0 || popA == null || popA.length == 0) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int startValue = popA[0];
        int startIndex = 0;
        while (startIndex != popA.length) {
            if (popA[startIndex] == startValue) {
                break;
            }
            startIndex++;
        }
//        for (int i = 0; i < popA.length; i++) {
//            int temp = popA[i];
//            for (int j = 0; j < pushA.length; j++) {
//                if (temp == pushA[j]) {
//                    startIndex = j;
//                    break;
//                }
//                if (startIndex != -1) {
//                    for (int k = 0; k < startIndex; k++) {
//                        stack.addLast(pushA[k]);
//                    }
//                }else {
//                    return false;
//                }
//
//            }
//        }
        return true;
    }

    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
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

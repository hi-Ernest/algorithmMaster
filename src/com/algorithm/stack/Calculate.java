package com.algorithm.stack;

import java.util.*;

/**
 * @author Ernest Chen
 * @date 2/14/21.
 */
public class Calculate {

    public int calculate(String s) {
        Deque<Character> optionStack = new LinkedList<>();
        Deque<Integer> valueStack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
        }

        return 0;
    }

    //1.字符串转int
    //String str = "123"
    public static int string2Int(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //先计算（c - '0'）避免int整型溢出
            n = 10 * n + (c - '0');
        }
        return n;
    }

    //2.加减算法
    public static int calculate2Operation(String s) {
        Deque<Integer> stack = new LinkedList<>();
        //将string2Int
        int num = 0;
        //记录num前的符号,初始化为'+'
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public int helper(String s) {
        Deque<Integer> stack = new LinkedList<>();
        //将string2Int
        int num = 0;
        //记录num前的符号,初始化为'+'
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            if (c == '(') {
                num = helper(s.substring(i + 1));
                s = s.substring(i);
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
//                s = s.substring(i + 1);
                break;
            }
        }
        return sumStack(stack);
    }


    private static int sumStack(Deque<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }



    public static void main(String[] args) {
//        System.out.println(string2Int("123"));
//        System.out.println(calculate2Operation("1*12+3+4/2"));

        String str = "2*4+(233-2)+1";
        System.out.println(str.substring(5));
        System.out.println(new Calculate().helper(str));
    }
}

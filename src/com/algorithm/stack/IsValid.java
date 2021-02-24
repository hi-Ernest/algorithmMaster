package com.algorithm.stack;

/**
 * @author Ernest Chen
 * @date 2/14/21.
 */
import java.util.*;
public class IsValid {

    private static Map<Character, Character> optionMap;

    static {
        optionMap = new HashMap<>();
        optionMap.put('(', ')');
        optionMap.put('{', '}');
        optionMap.put('[', ']');
    }

    public static boolean isValid(String s) {
        //使用栈来判断是否为有效的括号
        //使用map这样的数据结构存储两两对应的括号
        //将string 转化 char[] 然后遍历 - 使用栈
        char[] options = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : options) {
            if (optionMap.containsKey(c)) {
                stack.addFirst(c);
            } else if (!stack.isEmpty() && optionMap.get(stack.peekFirst()) == c) {
                stack.removeFirst();
            }else {
                return false;
            }
        }
        //括号全匹配的话 = 栈必须是清空的
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //单元测试
        String s = "[{})";
        System.out.println(isValid(s));
    }
}

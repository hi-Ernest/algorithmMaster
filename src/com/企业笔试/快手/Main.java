package com.企业笔试.快手;

import java.util.*;

/**
 * create by Ernest on 2020/4/12.
 */
public class Main {

    static int valid = 0;
    static int onlyLeft = 0;
    static int onlyRight = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == ')') {
                if (input.charAt(i) == '(') {
                    onlyLeft++;
                }else if (input.charAt(i) == ')') {
                    onlyRight++;
                }
                stringBuilder.append(input.charAt(i));
            }
        }
        new Main().ValidAndCount(stringBuilder.toString());
        System.out.println(valid + " "+ (onlyLeft - valid) + " "+ (onlyRight - valid));
    }


    public void ValidAndCount(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');

        for (int i=0; i<s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
                continue;
            }

            char ch = stack.peek();
            if (map.containsKey(ch) && map.get(ch) == s.charAt(i)) {
                stack.pop();
                valid++;
                continue;
            }
            stack.push(s.charAt(i));
        }
    }
}

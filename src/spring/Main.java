package spring;

import java.util.Stack;

/**
 * @author Ernest Chen
 * @date 2021/1/29.
 */
public class Main {

    private static volatile Main instance;

    public static Main getInstance() {
        if (instance == null) {
            synchronized (Main.class) {
                if (instance == null) {
                    instance = new Main();
                }
            }
        }
        return instance;
    }

    public static void revertString(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        revertString("1234");
    }

    //lock <- redisClient.getLock();
    //try {
    //  if(lock != null) {
    //      业务代码
    //  }
    // }finaly{
    //      lock.unlock;
    // }




}

package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ernest Chen
 * @date 2021/2/11.
 */
public class ConCurrent {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndAdd(23);
        String str1 = "12";
        char[] options = str1.toCharArray();
    }
}

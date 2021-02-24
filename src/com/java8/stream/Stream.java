package com.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ernest Chen
 * @date 2020/8/3.
 */
public class Stream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 12, 2, 21);
        list = list.stream().filter(item -> item % 2 ==0).collect(Collectors.toList());
        System.out.println(list);
    }
}

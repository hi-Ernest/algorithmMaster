package com.企业笔试;

import java.util.*;
/**
 * create by Ernest on 2020/4/1.
 */
public class LRUCache_{
    int capacity;
    Map<Integer, Integer> map;

    public LRUCache_(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //先删除旧的位置，再放入新位置
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        //超出capacity，删除最久没用的,利用迭代器，删除第一个
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        LRUCache_ lruCache_ = new LRUCache_(capacity);
        while (scanner.hasNext()) {
            String[] inpus = scanner.nextLine().split(" ");
            if (inpus[0].equals("p")) {
                lruCache_.map.put(Integer.parseInt(inpus[1]), Integer.parseInt(inpus[2]));
            }else {
                System.out.println(lruCache_.map.get(Integer.parseInt(inpus[1])));
            }
        }
    }
}


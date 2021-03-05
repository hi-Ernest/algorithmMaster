package com.algorithm.z_datastruct;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @author Ernest Chen
 * @date 3/4/21 10:56 PM.
 */
public class Map {

    public static void main(String[] args) {
//        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>(4, 0.75f,true);
//        linkedHashMap.put(1,2);
//        linkedHashMap.put(2,2);
//        linkedHashMap.put(3,2);
//
//        linkedHashMap.get(2);
//        Iterator<Integer> iterator = linkedHashMap.keySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(32,2);
        treeMap.put(1,2);
        treeMap.put(2,2);
        treeMap.put(3,2);
        for (int key : treeMap.keySet()) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }
}

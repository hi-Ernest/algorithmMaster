package com.algorithm.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * create by Ernest on 2020/4/11.
 */
public class LRUCache_<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTERIES = 3;

    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > MAX_ENTERIES;
    }

    LRUCache_() {
        super(MAX_ENTERIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache_<Integer, String> lruCache_ = new LRUCache_<>();
        lruCache_.put(1, "a");
        lruCache_.put(2, "b");
        lruCache_.put(3, "c");
        lruCache_.get(1);
        lruCache_.put(4, "d");

        System.out.println(lruCache_.keySet());
    }
}

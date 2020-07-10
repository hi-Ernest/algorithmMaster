package com.algorithm.LRUCache;

import java.util.*;

/**
 * create by Ernest on 2020/4/5.
 */
public class LRULinkedHashMap {
    private int capacity;
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRULinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        put(key, val);
        return val;
    }


    public void put(int key, int value) {
        if (!map.containsKey(key) && map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.remove(key);
        map.put(key, value);
    }

    /**
     * 补充：
     * @param <K>
     * @param <V>
     */
    class LRUCache<K, V> {
        private Map<K, V> map;
        private final int cacheSize;

        public LRUCache(int initialCapacity) {
            map = new LinkedHashMap<K, V>(initialCapacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > cacheSize;
                }
            };
            this.cacheSize = initialCapacity;
        }
    }
}

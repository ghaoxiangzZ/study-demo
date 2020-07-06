package com.demo.LRU;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author haoxiang_guo
 * @version 1.0.0
 * @ClassName LRULinkedHashMap.java
 * @Description TODO
 * @createTime 2020年06月22日 09:45:00
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap {

    private int capacity;

    public LRULinkedHashMap(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap(4);
        lruLinkedHashMap.put(1, 1);
        lruLinkedHashMap.put(2, 2);
        lruLinkedHashMap.put(3, 3);
        lruLinkedHashMap.put(4, 4);
        lruLinkedHashMap.put(5, 5);
        Iterator<Map.Entry> it = lruLinkedHashMap.entrySet().iterator();
        // size() > capaticy,所以第一个节点<1, 1>被删除了
        while (it.hasNext()) {
            System.out.println(it.next().getKey());
        }
    }
}

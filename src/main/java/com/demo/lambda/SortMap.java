package com.demo.lambda;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java8 lambda表达式对Map values进行排序
 */
public class SortMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("haoxiang", 4);
        map.put("zhangsan", 2);
        map.put("lisi", 3);
        map.put("wangwu", 1);
        System.out.println("Original...");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println("Sorted...");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

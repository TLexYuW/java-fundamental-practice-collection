package com.lex.practice.jakobjenkov.iterator;

import java.util.*;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class IteratorExample1_2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add(("ABC"));
        list.add("xyz");
        Iterator<String> iterator1 = list.iterator();

        while (iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println(next);
        }

        Set<String> set = new HashSet<>();
        set.add("123");
        set.add(("ABC"));
        set.add("xyz");
        Iterator<String> iterator2 = set.iterator();

        while (iterator2.hasNext()){
            String next = iterator2.next();
            System.out.println(next);
        }

        Map<String, String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        Iterator<String> keyIterator = map.keySet().iterator();
        Iterator<String> valueIterator = map.values().iterator();
        Iterator<Map.Entry<String, String>> iterator3 = map.entrySet().iterator();

        while (keyIterator.hasNext()){
            String next = keyIterator.next();
            System.out.println(next);
        }
        while (valueIterator.hasNext()){
            String next = valueIterator.next();
            System.out.println(next);
        }
        while (iterator3.hasNext()){
            Map.Entry<String, String> next = iterator3.next();
            System.out.println(next);
        }

    }

}

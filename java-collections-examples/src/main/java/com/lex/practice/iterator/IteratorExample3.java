package com.lex.practice.iterator;

import java.util.*;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class IteratorExample3 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("123");
        list.add(("ABC"));
        list.add("xyz");
        Iterator iterator1 = list.iterator();

        while (iterator1.hasNext()){
            String next = (String) iterator1.next();
            System.out.println(next);
        }

        Map map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        Iterator keyIterator = map.keySet().iterator();
        Iterator valueIterator = map.values().iterator();
        Iterator iterator3 = map.entrySet().iterator();

        while (keyIterator.hasNext()){
            String next = (String) keyIterator.next();
            System.out.println(next);
        }
        while (valueIterator.hasNext()){
            String next = (String) valueIterator.next();
            System.out.println(next);
        }
        while (iterator3.hasNext()){
            Map.Entry next = (Map.Entry) iterator3.next();
            System.out.println(next);
        }
    }
}

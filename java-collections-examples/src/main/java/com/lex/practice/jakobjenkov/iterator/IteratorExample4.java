package com.lex.practice.jakobjenkov.iterator;

import java.util.*;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class IteratorExample4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add(("ABC"));
        list.add("xyz");
        System.out.println(list.size());
        Iterator<String> iterator1 = list.iterator();

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
//            list.remove(list.size()-1); // ConcurrentModificationException
        }

        // modify the list
        list.remove(list.size()-1);

        Iterator<String> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}

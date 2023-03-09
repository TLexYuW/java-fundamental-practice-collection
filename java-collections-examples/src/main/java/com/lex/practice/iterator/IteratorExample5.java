package com.lex.practice.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class IteratorExample5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add(("ABC"));
        list.add("xyz");
//        System.out.println(list.size());
        Iterator<String> iterator = list.iterator();

        iterator.forEachRemaining( e -> System.out.println(e));
//        iterator.forEachRemaining(System.out::println);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(list.size()); // 0
    }
}

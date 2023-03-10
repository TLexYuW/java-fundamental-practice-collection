package com.lex.practice.jakobjenkov.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class ListIteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add(("ABC"));
        list.add("xyz");
        System.out.println("============================");
        ListIterator<String> listIterator = list.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("===========Reverse==========");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}

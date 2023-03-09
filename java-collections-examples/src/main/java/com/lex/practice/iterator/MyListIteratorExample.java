package com.lex.practice.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/9
 */
public class MyListIteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        MyListIterator<String> iterator = new MyListIterator<>(list);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

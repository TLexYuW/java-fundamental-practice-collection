package com.lex.practice.unsorted.unmodifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("x");

        Collection<String> unmodifiabledCollection = Collections.unmodifiableCollection(list);

        unmodifiabledCollection.add("y"); // error

        System.out.println(unmodifiabledCollection.size());
    }
}

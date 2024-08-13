package com.lex.practice.util.collectors.collecting_and_then;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 4, 3, 5, 4);
        List<Integer> result = list.stream()
                .collect(Collectors.collectingAndThen(
                                Collectors.toCollection(() -> new TreeSet<Integer>(Comparator.naturalOrder())),
                                ArrayList::new
                        )
                );
        System.out.println(result);
    }
}

package com.lex.practice.util.collections.maps.merge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeDemo {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "orange", "apple", "orange", "banana");

        Map<String, Integer> itemCounts = items.stream()
                .collect(Collectors.toMap(
                        item -> item, // keyMapper: use the item itself as the key
                        item -> 1,    // valueMapper: each item counts as 1
                        Integer::sum  // mergeFunction: sum the values for duplicate keys
                ));

        System.out.println(itemCounts);
        // Output: {banana=2, orange=2, apple=2}
    }
}

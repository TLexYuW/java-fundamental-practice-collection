package com.lex.practice.util.collections.maps.merge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeDemo2 {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple:1", "banana:2", "orange:3", "apple:4", "orange:5", "banana:6");

        Map<String, String> concatenatedValues = items.stream()
                .collect(Collectors.toMap(
                        item -> item.split(":")[0],  // keyMapper: extract the item name
                        item -> item.split(":")[1],  // valueMapper: extract the item value
                        (oldValue, newValue) -> oldValue + "," + newValue // mergeFunction: concatenate the values
                ));

        System.out.println(concatenatedValues);
        // Output: {banana=2,6, orange=3,5, apple=1,4}
    }
}

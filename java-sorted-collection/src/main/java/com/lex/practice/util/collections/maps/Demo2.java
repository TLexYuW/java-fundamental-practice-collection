package com.lex.practice.util.collections.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Lex Yu
 */
public class Demo2 {
    public static void main(String[] args) {
        List<SomeObject> list = List.of(
                new SomeObject("001", null, "Q01"),
                new SomeObject("C999", "001", null),
                new SomeObject("C785", null, "P01")
        );

        Map<String, String> lookupMap = new HashMap<>();

        for (SomeObject obj : list) {
            if (obj.getLatestKey() != null) {
                lookupMap.put(obj.getMasterKey(), obj.getLatestKey());
            }
        }

        Map<String, String> resultMap = new HashMap<>();

        for (SomeObject obj : list) {
            String key = obj.getMasterKey();
            String value;
            if (obj.getParentKey() != null) {
                value = lookupMap.get(obj.getParentKey());
            } else {
                value = obj.getLatestKey();
            }
            resultMap.put(key, value);
        }

        // Print the resulting map
        resultMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}

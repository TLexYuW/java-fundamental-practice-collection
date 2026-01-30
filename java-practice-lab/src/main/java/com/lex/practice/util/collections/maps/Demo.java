package com.lex.practice.util.collections.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        List<SomeObject> list = List.of(
                new SomeObject("001", null, "Q01"),
                new SomeObject("C999", "001", null),
                new SomeObject("C785", null, "P01")
        );

        Map<String, Map<String, String>> resultMap = list.stream().collect(
                Collectors.groupingBy(
                        SomeObject::getMasterKey, // Outer map key
                        Collectors.toMap(
                                SomeObject::getParentKey,
                                obj -> obj.getLatestKey() != null ? obj.getLatestKey() : "",
                                (v1, v2) -> v1,
                                HashMap::new
                        )
                )
        );

        // Print the resulting map
        resultMap.forEach((key, innerMap) -> {
            System.out.println(key + " -> " + innerMap);
        });
    }
}

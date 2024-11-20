package com.lex.practice.util.optional._2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        // Mock 三種不同的 List 情境
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = List.of();  // 空List
        List<String> list3 = null;  // null List

        // 測試函數
        testOptional(list1, "情境1 (List 包含元素)");  // 預期輸出：ABC
        testOptional(list2, "情境2 (空 List)");      // 預期輸出：0
        testOptional(list3, "情境3 (null List)");    // 預期輸出：0
    }

    private static void testOptional(List<String> list, String message) {
        String result = Optional.ofNullable(list)
                .map(l -> {
                    System.out.println("through...");
                    return l.isEmpty() ? "0" : String.join("", l);
                })
                .orElse("0");
        System.out.println(message + ": " + result);
    }
}

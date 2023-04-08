package com.lex.example_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LEX_YU
 * @date : 2023/4/8
 * @last_modified_date : 2023-2023/4/8
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // This will result in a compile-time error
        // List<Object> objList = list;

        // This will work
        List<Object> objList = (List<Object>) (List<?>) list;
        objList.forEach(x -> {
            System.out.printf("result = %s, value = %s\n", (x instanceof Integer), x);
        });
        objList.forEach(x -> {
            System.out.printf("result = %s, value = %s\n", (x instanceof String), x);
        });

        // This will result in a runtime error
//         String s = (String) objList.get(0);
    }
}

package com.lex.unsorted.finalSection;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author : LEX_YU
 * @date : 20/11/2022 2:22 pm
 */
public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = name -> {
            // logic
             if(name.isBlank()) throw new IllegalArgumentException("");
             return name.toUpperCase();
        };
        System.out.println(upperCaseName.apply("test"));

        String test = upperCaseName2.apply("Alex", 20);
        System.out.println(test);
    }

    // static method not practical
    static BiFunction<String, Integer, String> upperCaseName2 = (name, age) -> {
        // logic
        if(name.isBlank()) throw new IllegalArgumentException("");
        System.out.println(age);
        return name.toUpperCase();
    };

    /*
    class Service {
        private BiFunction<String, Integer, String> upperCaseName2 = (name, age) -> {
            // logic
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };
    }
     */

}

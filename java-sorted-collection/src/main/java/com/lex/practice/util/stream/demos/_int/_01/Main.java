package com.lex.practice.util.stream.demos._int._01;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 90).forEach(System.out::println);
    }
}

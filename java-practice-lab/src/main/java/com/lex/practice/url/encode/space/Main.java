package com.lex.practice.url.encode.space;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Encoding spaces
        String stringWithSpaces = "Hello World";
        String encodedSpaces = URLEncoder.encode(stringWithSpaces, StandardCharsets.UTF_8);
        System.out.println("Encoded spaces example:");
        System.out.println("Original: " + stringWithSpaces);
        System.out.println("Encoded: " + encodedSpaces);
        System.out.println();
    }
}

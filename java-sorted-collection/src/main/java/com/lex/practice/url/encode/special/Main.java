package com.lex.practice.url.encode.special;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Encoding special characters, @
        String stringWithSpecialChars = "user@example.com";
        String encodedSpecialChars = URLEncoder.encode(stringWithSpecialChars, StandardCharsets.UTF_8);
        System.out.println("Encoded special characters example:");
        System.out.println("Original: " + stringWithSpecialChars);
        System.out.println("Encoded: " + encodedSpecialChars);
        System.out.println();
    }
}

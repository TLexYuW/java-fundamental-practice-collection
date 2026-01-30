package com.lex.practice.url.encode.reserved_charac;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Encoding reserved characters  /, ?, =, and #
        String stringWithReservedChars = "/path/to/resource?query=value#fragment";
        String encodedReservedChars = URLEncoder.encode(stringWithReservedChars, StandardCharsets.UTF_8);
        System.out.println("Encoded reserved characters example:");
        System.out.println("Original: " + stringWithReservedChars);
        System.out.println("Encoded: " + encodedReservedChars);
    }
}

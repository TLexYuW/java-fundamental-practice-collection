package com.lex.practice.url.encode.ascii;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Encoding non-printable ASCII characters
        String stringWithNonPrintableChars = "This \u0003 is a non-printable character";
        String encodedNonPrintableChars = URLEncoder.encode(stringWithNonPrintableChars, StandardCharsets.UTF_8);
        System.out.println("Encoded non-printable ASCII characters example:");
        System.out.println("Original: " + stringWithNonPrintableChars);
        System.out.println("Encoded: " + encodedNonPrintableChars);
        System.out.println();
    }
}

package com.lex.practice.crypto.encode;

import java.security.SecureRandom;
import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) {
        // 1.
        byte[] keyBytes = new byte[32];
        new SecureRandom().nextBytes(keyBytes);
        String secretKey1 = Base64.getEncoder().encodeToString(keyBytes);
        System.out.println(secretKey1);

        // 2.
        String originalKey = "my-secret-key";
        String secretKey2 = Base64.getEncoder().encodeToString(originalKey.getBytes());
        System.out.println(secretKey2);
        byte[] decode = Base64.getDecoder().decode(secretKey2);
        String decodedKey = new String(decode);
        System.out.println(decodedKey);
    }
}

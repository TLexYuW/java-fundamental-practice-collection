package com.lex.practice.crypto.hashing.hmac;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Hmac {
    private static final String key = "secret_key";

    public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] message = generateRandomMessage();
        String res = generateHMAC(key, message);;
        System.out.println("Secret Key: " + key);
        System.out.println("Message (Base64): " + Base64.getEncoder().encodeToString(message));
        System.out.println("HMAC-SHA256 (Base64): " + res);
    }

    public static byte[] generateRandomMessage() {
        byte[] msg = new byte[20];
        new SecureRandom().nextBytes(msg);
        return msg;
    }

    public static String generateHMAC(String secrete_key, byte[] message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec spec = new SecretKeySpec(secrete_key.getBytes(), "HmacSHA256");
        mac.init(spec);
        byte[] hmacBytes = mac.doFinal(message);
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
}

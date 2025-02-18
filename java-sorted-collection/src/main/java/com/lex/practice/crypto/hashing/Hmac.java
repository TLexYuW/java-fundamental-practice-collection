package com.lex.practice.crypto.hashing;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Hmac {
    private static final String key = "secret_key";

    public static void main(String[] args) {

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

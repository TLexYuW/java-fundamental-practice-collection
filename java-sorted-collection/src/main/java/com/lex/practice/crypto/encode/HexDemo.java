package com.lex.practice.crypto.encode;

import org.apache.commons.codec.binary.Hex;

public class HexDemo {
    public static void main(String[] args) {

    }

    private String bytesToHex2(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

    private String bytesToHex1(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}

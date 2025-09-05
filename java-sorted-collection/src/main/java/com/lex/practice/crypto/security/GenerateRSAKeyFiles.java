package com.lex.practice.crypto.security;

import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateRSAKeyFiles {

    public static void main(String[] args) throws Exception {
        // 建立 RSA KeyPair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // 鑰匙長度
        KeyPair keyPair = keyGen.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 存檔 (Binary 格式)
        try (FileOutputStream fos = new FileOutputStream("private.key")) {
            fos.write(privateKey.getEncoded());
        }
        try (FileOutputStream fos = new FileOutputStream("public.key")) {
            fos.write(publicKey.getEncoded());
        }
        System.out.println("✅ RSA 公私鑰已生成並存檔：public.key / private.key");

        // 生成 PEM 可讀格式
        String privatePEM = convertToPEM("PRIVATE KEY", privateKey.getEncoded());
        String publicPEM = convertToPEM("PUBLIC KEY", publicKey.getEncoded());

        // 存 PEM 檔案
        try (FileOutputStream fos = new FileOutputStream("private.pem")) {
            fos.write(privatePEM.getBytes());
        }
        try (FileOutputStream fos = new FileOutputStream("public.pem")) {
            fos.write(publicPEM.getBytes());
        }

        System.out.println("✅ RSA 公私鑰已生成 PEM 格式檔案：public.pem / private.pem");

        // 在 Console 展示 PEM 字串
        System.out.println("\n--- Private Key PEM ---\n" + privatePEM);
        System.out.println("\n--- Public Key PEM ---\n" + publicPEM);
    }

    // 將 byte[] 轉成 PEM 字串
    private static String convertToPEM(String type, byte[] encoded) {
        String base64 = Base64.getMimeEncoder(64, "\n".getBytes()).encodeToString(encoded);
        return "-----BEGIN " + type + "-----\n" + base64 + "\n-----END " + type + "-----\n";
    }
}

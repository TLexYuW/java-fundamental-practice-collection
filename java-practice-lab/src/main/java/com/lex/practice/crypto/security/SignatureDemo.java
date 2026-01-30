package com.lex.practice.crypto.security;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignatureDemo {
    public static void main(String[] args) throws Exception {
        String message = "Hello RSA Signature!";
        System.out.println("原始訊息: " + message);

        // ===== 載入 binary 金鑰 =====
        PrivateKey binaryPrivateKey = loadPrivateKeyBinary("private.key");
        PublicKey binaryPublicKey = loadPublicKeyBinary("public.key");
        System.out.println("\n=== 使用 binary key 簽章/驗章 ===");
        signAndVerify(message, binaryPrivateKey, binaryPublicKey);

        // ===== 載入 PEM 金鑰 =====
        PrivateKey pemPrivateKey = loadPrivateKeyPEM("private.pem");
        PublicKey pemPublicKey = loadPublicKeyPEM("public.pem");
        System.out.println("\n=== 使用 PEM key 簽章/驗章 ===");
        signAndVerify(message, pemPrivateKey, pemPublicKey);
    }

    // 簽章/驗章流程
    private static void signAndVerify(String message, PrivateKey privateKey, PublicKey publicKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        byte[] signatureBytes = sign.sign();
        String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);
        System.out.println("簽章(Base64): " + signatureBase64);

        Signature verify = Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());
        boolean isValid = verify.verify(Base64.getDecoder().decode(signatureBase64));
        System.out.println("驗章結果: " + isValid);
    }

    // ===== Binary Key 載入 =====
    private static PrivateKey loadPrivateKeyBinary(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePrivate(spec);
    }

    private static PublicKey loadPublicKeyBinary(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }

    // ===== PEM Key 載入 =====
    private static PrivateKey loadPrivateKeyPEM(String filename) throws Exception {
        String pem = new String(Files.readAllBytes(new File(filename).toPath()));
        pem = pem.replaceAll("-----BEGIN PRIVATE KEY-----", "")
                .replaceAll("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(pem);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        return KeyFactory.getInstance("RSA").generatePrivate(spec);
    }

    private static PublicKey loadPublicKeyPEM(String filename) throws Exception {
        String pem = new String(Files.readAllBytes(new File(filename).toPath()));
        pem = pem.replaceAll("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", "");
        byte[] decoded = Base64.getDecoder().decode(pem);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
        return KeyFactory.getInstance("RSA").generatePublic(spec);
    }
}

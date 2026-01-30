package com.lex.practice.crypto.hashing.sha256;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class Demo {
    public static void main(String[] args) {
        String secretKey = "87a78d62c99b44b3ca1309004000fe3d66eec505";

        HeaderSignature headerSig = new HeaderSignature(
                "12345678",
                "CLIENT",
                "SERVER",
                1751341000L,
                "CLIENT",
                secretKey
        );

        String signature = headerSig.generateSignature();
        System.out.printf("Generated Signature: %s%n", signature);

        HTTPHeaders headers = new HTTPHeaders(
                "12345678",
                "CLIENT",
                "SERVER",
                1751341000L,
                "CLIENT",
                signature
        );

        ValidationResult result = SignatureValidator.validateHeaders(headers, secretKey);
        if (!result.isValid()) {
            System.out.printf("Validation Error: %s%n", result.getErrorMessage());
            return;
        }

        System.out.printf("Signature Valid: %s%n", result.isValid());

        long currentTimestamp = Instant.now().getEpochSecond();
        System.out.printf("Current Timestamp: %d%n", currentTimestamp);
    }
}

@Setter
@Getter
class HeaderSignature {
    private String clientId;
    private String systemKind;
    private String platform;
    private long timestamp;
    private String source;
    private String secretKey;

    public HeaderSignature(String clientId, String systemKind, String platform, long timestamp, String source,
                           String secretKey) {
        this.clientId = clientId;
        this.systemKind = systemKind;
        this.platform = platform;
        this.timestamp = timestamp;
        this.source = source;
        this.secretKey = secretKey;
    }

    public String generateSignature() {
        String data = String.format("%s%s%s%d%s%s", clientId, systemKind, platform, timestamp, source, secretKey);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }

    public boolean verifySignature(String providedSignature) {
        String expectedSignature = generateSignature();
        return expectedSignature.equals(providedSignature);
    }

    private String bytesToHex(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }
}

@Setter
@Getter
class HTTPHeaders {
    private String xClientId;
    private String xSystemKind;
    private String xPlatform;
    private long xTimestamp;
    private String xSource;
    private String xSignature;

    public HTTPHeaders(String xClientId, String xSystemKind, String xPlatform, long xTimestamp, String xSource,
                       String xSignature) {
        this.xClientId = xClientId;
        this.xSystemKind = xSystemKind;
        this.xPlatform = xPlatform;
        this.xTimestamp = xTimestamp;
        this.xSource = xSource;
        this.xSignature = xSignature;
    }

}


class SignatureValidator {

    public static ValidationResult validateHeaders(HTTPHeaders headers, String secretKey) {
        HeaderSignature headerSig = new HeaderSignature(
                headers.getXClientId(),
                headers.getXSystemKind(),
                headers.getXPlatform(),
                headers.getXTimestamp(),
                headers.getXSource(),
                secretKey
        );

        boolean isValid = headerSig.verifySignature(headers.getXSignature());
        if (!isValid) {
            return new ValidationResult(false, "Invalid signature");
        }

        return new ValidationResult(true, null);
    }
}


@Getter
class ValidationResult {
    private final boolean valid;
    private final String errorMessage;

    public ValidationResult(boolean valid, String errorMessage) {
        this.valid = valid;
        this.errorMessage = errorMessage;
    }
}
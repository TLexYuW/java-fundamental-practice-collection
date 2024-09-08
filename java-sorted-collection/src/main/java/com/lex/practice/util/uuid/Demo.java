package com.lex.practice.util.uuid;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println("Original UUID: " + uuid);

        byte[] bytes = convertUUIDToBytes(uuid);
        System.out.println("Converted byte array: " + Arrays.toString(bytes));

        UUID uuidNew = convertBytesToUUID(bytes);
        System.out.println("Converted UUID: " + uuidNew);

        if (uuid.equals(uuidNew)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static byte[] convertUUIDToBytes(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public static UUID convertBytesToUUID(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        long high = byteBuffer.getLong();
        long low = byteBuffer.getLong();
        return new UUID(high, low);
    }
}

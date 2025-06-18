package com.lex.practice.casual._2;

import java.util.Objects;


public class Base62 {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final long POSITIVE_MASK = 0x7FFFFFFFL;

    public static String encode(long num, int length) {
        num = Math.abs(num);

        if (num == 0) {
            return "0".repeat(length);
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(ALPHABET.charAt((int) (num % 62)));
            num /= 62;
        }

        while (sb.length() < length) {
            sb.append('0');
        }

        return sb.reverse().toString();
    }

    public static long decode(String encoded) {
        long result = 0;
        long power = 1;

        for (int i = encoded.length() - 1; i >= 0; i--) {
            char c = encoded.charAt(i);
            int value = ALPHABET.indexOf(c);

            if (value == -1) {
                throw new IllegalArgumentException("Invalid character: " + c);
            }

            result += value * power;
            power *= 62;
        }

        return result;
    }

    public static String getFinalCode(Long input) {
        long salt = System.currentTimeMillis();
        return Base62.encode(Objects.hash(input, salt) % 916132832L, 5);
    }

    public static String getFinalCode2(Long input) {
        long salt = 987654321L;
        long hash = (input * 1000000007L + salt) & POSITIVE_MASK;
        return Base62.encode(hash % 916132832L, 5);
    }

    public static String getFinalCode3(Long input) {
        long pattern = 0x5A5A5A5A5A5A5A5AL;
        long hash = ((input ^ pattern) * 1000000007L) & POSITIVE_MASK;
        return Base62.encode(hash % 916132832L, 5);
    }
    
    public static void main(String[] args) {
        System.out.println(getFinalCode(1L));
        System.out.println(getFinalCode2(1L));
        System.out.println(getFinalCode3(1L));

        System.out.println("===============================");

        System.out.println(getFinalCode(916_132_832L));
        System.out.println(getFinalCode2(916_132_832L));
        System.out.println(getFinalCode3(916_132_832L));

        System.out.println("===============================");

        System.out.println(getFinalCode(916_132_832L));
        System.out.println(getFinalCode2(916_132_832L));
        System.out.println(getFinalCode3(916_132_832L));

        System.out.println("===============================");

        System.out.println(getFinalCode(916_132_831L));
        System.out.println(getFinalCode2(916_132_831L));
        System.out.println(getFinalCode3(916_132_831L));

        System.out.println("===============================");

        System.out.println(getFinalCode(916_132_833L));
        System.out.println(getFinalCode2(916_132_833L));
        System.out.println(getFinalCode3(916_132_833L));

        System.out.println("===============================");

        System.out.println(getFinalCode(916_132_831L));
        System.out.println(getFinalCode2(916_132_831L));
        System.out.println(getFinalCode3(916_132_831L));

        System.out.println("===============================");

        System.out.println(getFinalCode(9_223_372_036_854_775_807L));
        System.out.println(getFinalCode2(9_223_372_036_854_775_807L));
        System.out.println(getFinalCode3(9_223_372_036_854_775_807L));

        System.out.println("===============================");

        System.out.println(getFinalCode(87654L));
        System.out.println(getFinalCode(916220486L));
        System.out.println(getFinalCode(1832353318L));
        System.out.println(getFinalCode(2748486150L));

        System.out.println("===============================");

        System.out.println(getFinalCode2(87654L));
        System.out.println(getFinalCode2(916220486L));
        System.out.println(getFinalCode2(1832353318L));
        System.out.println(getFinalCode2(2748486150L));

        System.out.println("===============================");

        System.out.println(getFinalCode3(87654L));
        System.out.println(getFinalCode3(916220486L));
        System.out.println(getFinalCode3(1832353318L));
        System.out.println(getFinalCode3(2748486150L));
    }
}

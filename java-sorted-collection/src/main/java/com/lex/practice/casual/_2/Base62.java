package com.lex.practice.casual._2;

import java.util.*;


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
        long salt = 9517534652L;
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

    // =======================================================================================================
    //
    // =======================================================================================================

    /**
     * 簡單碰撞測試 - 找出真正的不同input產生相同hash
     */
    public static void findCollision() {
        System.out.println("🔍 COLLISION HUNTER - 尋找真正的碰撞");
        System.out.println("目標：找到兩個不同input產生相同hash\n");

        Map<String, Long> hashToInput = new HashMap<>();
        Set<Long> usedInputs = new HashSet<>();
        Random random = new Random();

        long attempts = 0;
        long maxAttempts = 100_000_000L;

        while (attempts < maxAttempts) {
            long input;
            do {
                input = Math.abs(random.nextLong() % 100_000_000_000L); // 1000億範圍
            } while (usedInputs.contains(input));

            usedInputs.add(input);
            String hash = Base62.getFinalCode2(input);

            // 檢查是否碰撞
            Long existingInput = hashToInput.get(hash);
            if (existingInput == null) {
                hashToInput.put(hash, input);
            } else {
                System.out.printf("🎉 找到真正的碰撞！\n");
                System.out.printf("Hash: '%s'\n", hash);
                System.out.printf("Input 1: %,d\n", existingInput);
                System.out.printf("Input 2: %,d\n", input);
                System.out.printf("嘗試次數: %,d\n", attempts + 1);
                System.out.printf("唯一Input數: %,d\n", usedInputs.size());

                String hash1 = Base62.getFinalCode2(existingInput);
                String hash2 = Base62.getFinalCode2(input);
                System.out.printf("驗證: %s == %s ? %s\n", hash1, hash2, hash1.equals(hash2));

                long salt = 987654321L;
                long calc1 = (existingInput * 1000000007L + salt) & 0x7FFFFFFFL;
                long calc2 = (input * 1000000007L + salt) & 0x7FFFFFFFL;
                long final1 = calc1 % 916132832L;
                long final2 = calc2 % 916132832L;

                System.out.printf("\n📊 碰撞分析:\n");
                System.out.printf("Input %,d → 計算值 %,d → 最終值 %,d\n", existingInput, calc1, final1);
                System.out.printf("Input %,d → 計算值 %,d → 最終值 %,d\n", input, calc2, final2);
                System.out.printf("最終值相等: %s\n", (final1 == final2) ? "✅" : "❌");

                return; // 找到碰撞就結束
            }

            attempts++;

            // 進度報告
            if (attempts % 1_000_000 == 0) {
                System.out.printf("進度: %,d 次嘗試, %,d 唯一input, 還沒找到碰撞...\n",
                        attempts, usedInputs.size());

                // 記憶體管理
                if (usedInputs.size() > 50_000_000) {
                    System.out.println("⚠️ 記憶體使用過多，重新開始...");
                    hashToInput.clear();
                    usedInputs.clear();
                    System.gc();
                }
            }
        }

        System.out.printf("❌ 嘗試了 %,d 次未找到碰撞，唯一input: %,d\n", attempts, usedInputs.size());
        System.out.printf("💡 這表明你的Hash函數品質極佳！\n");
    }

    // =======================================================================================================
    // Utils
    // =======================================================================================================

    /**
     * 分析兩個碰撞輸入的計算過程
     */
    public static void analyzeBothInputs(long input1, long input2) {
        long salt = 987654321L;

        // 計算兩個input的hash過程
        long calc1 = (input1 * 1000000007L + salt) & 0x7FFFFFFFL;
        long calc2 = (input2 * 1000000007L + salt) & 0x7FFFFFFFL;
        long final1 = calc1 % 916132832L;
        long final2 = calc2 % 916132832L;

        System.out.printf("\n📊 碰撞分析:\n");
        System.out.printf("Input %,d → 計算值 %,d → 最終值 %,d\n", input1, calc1, final1);
        System.out.printf("Input %,d → 計算值 %,d → 最終值 %,d\n", input2, calc2, final2);
        System.out.printf("最終值相等: %s\n", (final1 == final2) ? "✅" : "❌");
    }


    // =======================================================================================================
    //
    // =======================================================================================================

    public static void main(String[] args) {
//        System.out.println(getFinalCode2(5766487435L));
//        System.out.println(getFinalCode2(7460538475L));

        System.out.println("=== COLLISION DETECTION TEST ===\n");
        findCollision();
        System.out.println("🎯 碰撞測試完成！");
    }

    private static void output() {
        System.out.println(getFinalCode(1L));
        System.out.println(getFinalCode2(1L));
        System.out.println(getFinalCode3(1L));

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

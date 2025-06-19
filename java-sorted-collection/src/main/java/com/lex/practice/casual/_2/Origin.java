package com.lex.practice.casual._2;


public class Origin {
    private static final String ALPHABET_SET_ORIGIN = "NgQiRkPn2pAsSuTwBy3hCjUmVrD4EtWvXxFz5bdYfZ6GaH7JcK8LeM";
    private static final String[] STRINGS = ALPHABET_SET_ORIGIN.split("");

//    private static final String ALPHABET_SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABET_SET = "UVexpjls0gZkvw8K1HOAXEDQao75P6dcCrfiIMG3NL2utBSY4nmJqb9FyRTWzh";
    // =======================================================================================================
    // （Injective Function）
    // Revise
    // =======================================================================================================

    public static String encodeIdToBase62String(long id) {
        int mod = (int) id % 8;
        int prefixK = mod + 2;
        long encodedNumber = prefixK * 10_000_000L + id;

        return encodeBase62(encodedNumber);
    }

    public static String encodeBase62(long number) {
        StringBuilder sb = new StringBuilder();
        int base = ALPHABET_SET.length();

        while (number > 0) {
            int remainder = (int) (number % base);
            sb.append(ALPHABET_SET.charAt(remainder));
            number /= base;
        }

        return sb.reverse().toString();
    }

    public static long baseDecode(String encoded, String alphabet) {
        long num = 0;
        int base = alphabet.length();

        for (int i = 0; i < encoded.length(); i++) {
            char c = encoded.charAt(i);
            int val = alphabet.indexOf(c);
            if (val == -1) {
                throw new IllegalArgumentException("Invalid character in encoded string: " + c);
            }
            num = num * base + val;
        }

        return num;
    }

    public static long decodeWithOffset(long encodedNumber) {
        for (int mod = 0; mod < 8; mod++) {
            int k = mod + 2;
            long possibleNum = encodedNumber - (k * 10_000_000L);

            if (possibleNum % 8 == mod) {
                return possibleNum;
            }
        }
        throw new IllegalStateException("Unable to decode: no valid mod match found");
    }

    public static long decode(String hash, String alphabet) {
        long encodedNumber = baseDecode(hash, alphabet);
        return decodeWithOffset(encodedNumber);
    }


    // =======================================================================================================
    // Wrong naming and Confuse
    // =======================================================================================================

    public static String getHash(long num) {
        StringBuilder sb = new StringBuilder();
        int k = (int) num % 8;
        k += 2;
        num = k * 10000000 + num;

        long q = num;
        do {
            Object[] arr = getCarry(q);
            q = (long) arr[0];
            String rStr = (String) arr[1];
            sb.append(rStr);
        } while (q > 0);

        return sb.reverse().toString();
    }

    private static Object[] getCarry(long num) {
        int d = ALPHABET_SET_ORIGIN.length();
        long q = num / d;
        int r = (int) (num % d);
        return new Object[]{q, STRINGS[r]};
    }

    // ==================== BASIC TESTING FUNCTIONS ====================

    public static void testRange(long start, long end, long step) {
        System.out.println("=== Hash Range Analysis ===");
        System.out.printf("Range: %,d to %,d (step: %,d)%n", start, end, step);
        System.out.println("Number\t\tHash\t\tLength\tMod8");
        System.out.println("----------------------------------------------------");

        for (long i = start; i <= end; i += step) {
            String hash = getHash(i);
            System.out.printf("%,d\t\t%s\t\t%d\t%d%n", i, hash, hash.length(), i % 8);
        }
        System.out.println();
    }

    public static void quickTest(long start, long end, long step) {
        System.out.printf("Quick Test: %,d to %,d (step: %,d)%n", start, end, step);
        for (long i = start; i <= end; i += step) {
            String hash = getHash(i);
            System.out.printf("%,d: %s (len:%d, mod:%d)%n", i, hash, hash.length(), i % 8);
        }
        System.out.println();
    }

    public static void testSingle(long... numbers) {
        System.out.println("=== Single Number Test ===");
        for (long num : numbers) {
            String hash = getHash(num);
            System.out.printf("%,d → %s (length: %d, mod: %d)%n", num, hash, hash.length(), num % 8);
        }
        System.out.println();
    }

    // ==================== BOUNDARY SEARCH FUNCTIONS ====================

    /**
     * 二分搜尋特定長度的邊界  找出5→6位的精確邊界
     */
    public static long findBoundary(int targetMod) {
        System.out.printf("🔍 Finding mod %d boundary...%n", targetMod);

        // 數學預估邊界位置
        long estimated = 916_132_832L - (targetMod + 2) * 10_000_000L;
        long searchStart = Math.max(1L, estimated - 1000);
        long searchEnd = estimated + 1000;

        // 調整到符合 mod 的範圍
        searchStart = searchStart + ((targetMod - searchStart % 8 + 8) % 8);
        searchEnd = searchEnd - ((searchEnd % 8 - targetMod + 8) % 8);

        System.out.printf("  Searching: %,d to %,d%n", searchStart, searchEnd);

        // 精確搜尋邊界點
        for (long i = searchStart; i <= searchEnd; i += 8) {
            String hash = getHash(i);
            String nextHash = getHash(i + 8);

            if (hash.length() != nextHash.length()) {
                System.out.printf("✅ Found: %,d (%d digits) → %,d (%d digits)%n",
                        i, hash.length(), i + 8, nextHash.length());
                return i;
            }
        }

        System.out.println("❌ Not found in estimated range");
        return -1;
    }

    /**
     * 驗證邊界附近的數字
     */
    public static void verifyBoundary(long boundary, int mod) {
        System.out.println("Verification:");
        for (long i = boundary - 16; i <= boundary + 24; i += 8) {
            if (i > 0 && i % 8 == mod) {
                String hash = getHash(i);
                String indicator = (i == boundary) ? " ← BOUNDARY" :
                        (i == boundary + 8) ? " ← NEXT" : "";
                System.out.printf("  %,d: %s (len: %d)%s%n", i, hash, hash.length(), indicator);
            }
        }
        System.out.println();
    }

    /**
     * 找所有mod的邊界
     */
    public static void findAllBoundaries() {
        System.out.println("=== Finding All 5→6 Digit Boundaries ===");

        for (int mod = 0; mod < 8; mod++) {
            System.out.printf("\n--- Mod %d ----%n", mod);

            long boundary = findBoundary(mod);
            if (boundary > 0) {
                verifyBoundary(boundary, mod);
            }
        }
    }



    // ==================== MAIN METHOD ====================

    public static void main(String[] args) {
//        test1();

        String encoded = encodeIdToBase62String(1L);
        System.out.println(encoded);
        long numbers = baseDecode(encoded, ALPHABET_SET);
        System.out.println(numbers);
        long restored = decodeWithOffset(numbers);
        System.out.println(restored);

//        long end = 10L;
//        for (long i = 1; i <= end; i ++) {
//            String hash = getHash(i);
//            long restored = decode(hash, ALPHABET_SET_ORIGIN);
//            System.out.printf("原始: %d\n編碼: %s\n還原: %d\n", i, hash, restored);
//            System.out.println(i == restored ? "✅ 正確還原" : "❌ 還原失敗");
//        }

    }

    private static void test1() {
        System.out.println(getHash(1));
        System.out.println(getHash(886_132_833));
        findAllBoundaries();
        long boundary = findBoundary(1);
        verifyBoundary(boundary, 1);
    }

}

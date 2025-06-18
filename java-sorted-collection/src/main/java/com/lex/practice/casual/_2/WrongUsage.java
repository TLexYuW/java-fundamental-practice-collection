package com.lex.practice.casual._2;


public class WrongUsage {

    // ==================== CORE HASH FUNCTIONS ====================

    private static final String HASH_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String[] HASH_STR_ARR = HASH_STR.split("");

    private static Object[] getCarry(long num) {
        int d = HASH_STR.length();
        long q = num / d;
        int r = (int) (num % d);
        return new Object[]{q, HASH_STR_ARR[r]};
    }

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
        System.out.println(getHash(1));
        System.out.println(getHash(886_132_833));
//        findAllBoundaries();
        long boundary = findBoundary(1);
        verifyBoundary(boundary, 1);
    }

}

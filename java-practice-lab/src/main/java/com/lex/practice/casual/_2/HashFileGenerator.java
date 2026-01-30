package com.lex.practice.casual._2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class HashFileGenerator {

    private static final String DATA_DIR = "hash_data";
    private static final String HASH_FILE = "hashes.csv";

    /**
     * 生成連續數字的Hash檔案 (1 到 maxInput)
     */
    public static void generateSequentialHashes(long maxInput) throws IOException {
        System.out.println("🚀 開始生成連續數字Hash檔案");
        System.out.printf("範圍: 1 到 %,d\n", maxInput);

        Files.createDirectories(Paths.get(DATA_DIR));
        String fileName = DATA_DIR + "/" + HASH_FILE;

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("input,hash"); // CSV header

            for (long input = 1; input <= maxInput; input++) {
                String hash = Base62.getFinalCode2(input);
                writer.printf("%d,%s%n", input, hash);

                if (input % 100_000 == 0) {
                    System.out.printf("進度: %,d/%,d (%.1f%%) 完成\r", input, maxInput, (input * 100.0 / maxInput));
                }
            }
        }

        System.out.printf("\n✅ Hash檔案生成完成: %s\n", fileName);
        System.out.printf("📊 總計: %,d 個連續數字\n", maxInput);
        System.out.println("💡 現在可以使用AWK腳本進行碰撞檢測");
    }

    /**
     * 動態擴展Hash檔案 - 從現有檔案繼續追加
     */
    public static void extendHashFile(long additionalCount) throws IOException {
        System.out.println("📈 開始動態擴展Hash檔案");

        String fileName = DATA_DIR + "/" + HASH_FILE;
        Path filePath = Paths.get(fileName);

        long currentMax = getCurrentMaxInput();

        if (currentMax > 0) {
            System.out.printf("📊 現有檔案最大input: %,d\n", currentMax);
        } else {
            System.out.println("📁 檔案不存在，將建立新檔案");
            Files.createDirectories(Paths.get(DATA_DIR));
        }

        long startFrom = currentMax + 1;
        long endAt = currentMax + additionalCount;

        System.out.printf("🎯 擴展範圍: %,d 到 %,d (新增 %,d 筆)\n",
                startFrom, endAt, additionalCount);

        boolean isNewFile = !Files.exists(filePath);
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {

            if (isNewFile) {
                writer.println("input,hash");
            }

            for (long input = startFrom; input <= endAt; input++) {
                String hash = Base62.getFinalCode2(input);
                writer.printf("%d,%s%n", input, hash);

                if ((input - startFrom + 1) % 100_000 == 0) {
                    long progress = input - startFrom + 1;
                    System.out.printf("進度: %,d/%,d (%.1f%%) 完成\r", progress, additionalCount, (progress * 100.0 / additionalCount));
                }
            }
        }

        System.out.printf("\n✅ 擴展完成！新範圍: 1 到 %,d\n", endAt);
        System.out.println("💡 現在可以使用AWK腳本進行碰撞檢測");
    }

    /**
     * 取得檔案當前的最大input值
     */
    public static long getCurrentMaxInput() throws IOException {
        String fileName = DATA_DIR + "/" + HASH_FILE;
        Path filePath = Paths.get(fileName);

        if (!Files.exists(filePath)) {
            return 0;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line = reader.readLine();
            String lastLine = null;

            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }

            if (lastLine != null) {
                String[] parts = lastLine.split(",");
                return Long.parseLong(parts[0]);
            }
        }

        return 0;
    }

    /**
     * 顯示檔案統計資訊
     */
    public static void showFileStats() throws IOException {
        String fileName = DATA_DIR + "/" + HASH_FILE;
        Path filePath = Paths.get(fileName);

        if (!Files.exists(filePath)) {
            System.out.println("❌ Hash檔案不存在");
            return;
        }

        long fileSize = Files.size(filePath);
        long lineCount;
        long maxInput = getCurrentMaxInput();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            lineCount = reader.lines().count() - 1; // 排除header
        }

        System.out.printf("📊 檔案統計:\n");
        System.out.printf("檔案路徑: %s\n", fileName);
        System.out.printf("檔案大小: %,d bytes (%.2f MB)\n", fileSize, fileSize / 1024.0 / 1024.0);
        System.out.printf("資料筆數: %,d\n", lineCount);
        System.out.printf("數字範圍: 1 到 %,d\n", maxInput);
        System.out.printf("檔案完整性: %s\n", (lineCount == maxInput) ? "✅ 完整" : "⚠️ 可能有間隙");

        // 顯示檔案樣本
        System.out.println("\n📝 檔案內容樣本:");
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            for (int i = 0; i < 5 && reader.ready(); i++) {
                System.out.println(reader.readLine());
            }
            System.out.println("...");
        }
    }

    /**
     * 清理資料目錄
     */
    public static void cleanData() throws IOException {
        Path dataDir = Paths.get(DATA_DIR);
        if (Files.exists(dataDir)) {
            Files.walk(dataDir)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
            System.out.println("🧹 資料目錄已清理");
        } else {
            System.out.println("📁 資料目錄不存在，無需清理");
        }
    }

    /**
     * Main方法 - 簡化選單
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Hash檔案生成器 (搭配AWK檢測) ===");
            System.out.println("1. 生成初始Hash檔案 (1 到 N)");
            System.out.println("2. 擴展現有Hash檔案");
            System.out.println("3. 顯示檔案統計");
            System.out.println("4. 清理資料");
            System.out.println("0. 退出");
            System.out.print("請選擇操作: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("輸入最大數字 (建議: 1000000): ");
                    long maxInput = scanner.nextLong();
                    generateSequentialHashes(maxInput);
                    break;

                case 2:
                    long currentMax = getCurrentMaxInput();
                    if (currentMax == 0) {
                        System.out.println("❌ 沒有現有檔案，請先選擇選項1建立檔案");
                        break;
                    }
                    System.out.printf("目前最大input: %,d\n", currentMax);
                    System.out.print("輸入要新增的數量: ");
                    long additionalCount = scanner.nextLong();
                    extendHashFile(additionalCount);
                    break;

                case 3:
                    showFileStats();
                    break;

                case 4:
                    System.out.print("確定要清理所有資料嗎? (y/N): ");
                    scanner.nextLine(); // 清除緩衝
                    String confirm = scanner.nextLine();
                    if (confirm.toLowerCase().startsWith("y")) {
                        cleanData();
                    } else {
                        System.out.println("取消清理操作");
                    }
                    break;

                case 0:
                    System.out.println("👋 程式結束");
                    System.out.println("💡 提醒: 使用AWK腳本進行高效碰撞檢測!");
                    return;

                default:
                    System.out.println("❌ 無效選擇");
            }
        }
    }
}

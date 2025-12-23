package com.lex.practice.watermark;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class DiagonalChineseWatermark {

    public static void main(String[] args) throws Exception {
        // 讀取 resources 資料夾裡的圖片
        InputStream inputStream = DiagonalChineseWatermark.class
                .getClassLoader()
                .getResourceAsStream("imgs/cat.jpg");

        if (inputStream == null) {
            throw new RuntimeException("Resource not found: imgs/cat.jpg");
        }

        BufferedImage src = ImageIO.read(inputStream);

        // 浮水印處理
        BufferedImage result = addWatermark(src);

        // ===== 使用 Path API =====
        Path outputDir = Paths.get("java-sorted-collection", "src", "main", "resources", "output");

        // 建立目錄（如果不存在）
        Files.createDirectories(outputDir);

        Path outputFile = outputDir.resolve("watermarked_cat.jpg");
        ImageIO.write(result, "jpg", outputFile.toFile());
        System.out.println("Watermark done!");
    }

    public static BufferedImage addWatermark(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        // 高品質渲染
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        // 繪製原圖
        g.drawImage(src, 0, 0, null);

        // 旋轉設定
        double angle = Math.atan2(height, width);
        g.rotate(-angle, width / 2.0, height / 2.0);

        // 浮水印樣式
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f));
        g.setColor(Color.GRAY);

        int fontSize = Math.max(width, height) / 15;
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
        g.setFont(font);

        // ===== 精確測量文字尺寸 =====
        FontMetrics fm = g.getFontMetrics(font);

        // 先產生一個樣本文字來測量
        Random random = new Random();
        String sampleText = randomChinese(random, 6);

        // 精確測量文字的實際寬度和高度
        int textWidth = fm.stringWidth(sampleText);   // 實際寬度（像素）
        int textHeight = fm.getHeight();              // 實際高度（包含行距）

        // ===== 設定間距（確保不重疊）=====
        // 水平間距 = 文字寬度 × 1.5（留 50% 空白）
        int stepX = (int) (textWidth * 1.5);

        // 垂直間距 = 文字高度 × 2.0（留 100% 空白）
        int stepY = (int) (textHeight * 2.0);

        // 計算覆蓋範圍
        int diagonal = (int) Math.sqrt(width * width + height * height);
        int coverRange = diagonal / 2;

        // 繪製浮水印
        for (int x = -coverRange; x < width + coverRange; x += stepX) {
            for (int y = -coverRange; y < height + coverRange; y += stepY) {
                // 每次產生新的隨機文字
                String watermarkText = randomChinese(random, 6);
                g.drawString(watermarkText, x, y);
            }
        }

        g.dispose();
        return image;
    }

    /**
     * 產生指定長度的隨機中文字串
     */
    private static String randomChinese(Random random, int length) {
        // 使用 StringBuilder 高效拼接字串
        StringBuilder sb = new StringBuilder(length);

        // 迴圈產生指定數量的中文字
        for (int i = 0; i < length; i++) {
            // ===== Unicode 中文字元範圍 =====
            // 0x4E00 (19968): CJK 統一表意文字起始碼位
            // 0x9FFF (40959): CJK 統一表意文字結束碼位
            // 範圍涵蓋：常用漢字 + 次常用漢字

            // random.nextInt(範圍) 產生 0 到 範圍-1 的隨機數
            // 加上 0x4E00 得到中文字的 Unicode 碼位
            char c = (char) (0x4E00 + random.nextInt(0x9FFF - 0x4E00));

            // 將字元加入字串
            sb.append(c);
        }

        // 回傳組裝好的隨機中文字串
        return sb.toString();
    }
}


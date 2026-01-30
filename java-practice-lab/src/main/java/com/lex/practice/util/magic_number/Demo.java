package com.lex.practice.util.magic_number;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {
    public static void main(String[] args) {
        localDemo("");
//        urlDemo("");
    }

    private static void urlDemo(String imgUrl) {
        try {
            byte[] imageBytes = readImageFromURL(imgUrl);
            if (imageBytes != null) {
                String imageType = detectImageType(imageBytes);
                System.out.println("檔案格式: " + imageType);
            } else {
                System.out.println("無法讀取圖片");
            }
        } catch (IOException e) {
            System.err.println("讀取圖片失敗: " + e.getMessage());
        }
    }

    private static void localDemo(String localPath) {
        try {
            byte[] imageBytes = readImage(localPath);
            String imageType = detectImageType(imageBytes);
            System.out.println("檔案格式: " + imageType);
        } catch (IOException e) {
            System.err.println("讀取圖片失敗: " + e.getMessage());
        }
    }

    private static byte[] readImageFromURL(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (InputStream inputStream = connection.getInputStream()) {
            byte[] header = new byte[12]; // 只讀取前 12 bytes
            int bytesRead = inputStream.read(header);
            if (bytesRead < 12) {
                return null;
            }
            return header;
        }
    }

    private static byte[] readImage(String path) throws IOException {
        Path imagePath = Paths.get(path);
        return Files.readAllBytes(imagePath);
    }

    private static String detectImageType(byte[] content) {
        if (content.length < 12) {
            return "";
        }

        if (content[0] == (byte) 0xFF && content[1] == (byte) 0xD8 && content[2] == (byte) 0xFF) {
            return "image/jpeg";
        }

        if (content[0] == (byte) 0x89 && content[1] == (byte) 0x50
                && content[2] == (byte) 0x4E && content[3] == (byte) 0x47
                && content[4] == (byte) 0x0D && content[5] == (byte) 0x0A
                && content[6] == (byte) 0x1A && content[7] == (byte) 0x0A) {
            return "image/png";
        }

        if (content[0] == 'R' && content[1] == 'I'
                && content[2] == 'F' && content[3] == 'F'
                && content[8] == 'W' && content[9] == 'E'
                && content[10] == 'B' && content[11] == 'P') {
            return "image/webp";
        }

        return "";
    }
}

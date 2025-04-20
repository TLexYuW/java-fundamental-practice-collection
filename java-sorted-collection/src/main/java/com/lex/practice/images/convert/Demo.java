package com.lex.practice.images.convert;

import com.luciad.imageio.webp.WebPWriteParam;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) throws IOException {

        byte[] original = readFileToBytes("imgs/1.png");
        byte[] webpBytes = convertToWebP(original, 0.9f);

        Path outputPath = Paths.get("output/imgs/1.webp");
        Files.createDirectories(outputPath.getParent());

        try (FileOutputStream fos = new FileOutputStream(outputPath.toFile())) {
            fos.write(webpBytes);
        }
    }

    private static byte[] readFileToBytes(String path) throws IOException {
        try (InputStream inputStream = Demo.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new FileNotFoundException("找不到 classpath 資源：" + path);
            }
            return inputStream.readAllBytes();
        }
    }

    public static byte[] convertToWebP(byte[] inputImageBytes, float quality) throws IOException {
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(inputImageBytes));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionType(param.getCompressionTypes()[WebPWriteParam.LOSSY_COMPRESSION]);
        param.setCompressionQuality(quality);

//        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
//        writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//        writeParam.setCompressionType(writeParam.getCompressionTypes()[WebPWriteParam.LOSSY_COMPRESSION]);
//        writeParam.setCompressionQuality(quality);

        try (ImageOutputStream ios = ImageIO.createImageOutputStream(outputStream)) {
            writer.setOutput(ios);
            writer.write(null, new javax.imageio.IIOImage(image, null, null), param);
        } catch (IOException e) {
            throw new IOException("Error while writing WebP image: " + e.getMessage(), e);
        } finally {
            writer.dispose();
        }

        return outputStream.toByteArray();
    }
}

package com.lex.practice.jsoup.clean.demos;

import org.apache.commons.codec.binary.Hex;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities;
import org.jsoup.safety.Safelist;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Demo1 {
    public static void main(String[] args) {

        String htmlWithWhitespace = "<div style=\"font-family: 'Microsoft JhengHei', sans-serif;\">\n" +
                "                    <h2 style=\"color: #28a745;\"> 文章內容 </h2>\n" +
                "                    <article>\n" +
                "                        <h3>台灣的自然之美</h3>\n" +
                "                        <p>台灣，這座被稱為福爾摩沙（美麗之島）的寶島</p>\n" +
                "                    </article>\n" +
                "                </div>";

        String htmlWithoutWhitespace = "<div style=\"font-family: 'Microsoft JhengHei', sans-serif;\"><h2 style=\"color: #28a745;\">文章內容</h2><article><h3>台灣的自然之美</h3><p>台灣，這座被稱為福爾摩沙（美麗之島）的寶島</p></article></div>";

        output(htmlWithWhitespace, htmlWithoutWhitespace);
//        output1(htmlWithWhitespace, htmlWithoutWhitespace);
//        output2(htmlWithWhitespace, htmlWithoutWhitespace);
    }

    private static void output(String htmlWithWhitespace, String htmlWithoutWhitespace) {
        Safelist safelist = Safelist.none();
        safelist.addTags("div", "h2", "h3", "p", "article");
        safelist.addAttributes("div", "style");
        safelist.addAttributes("h2", "style");
        safelist.addAttributes("h3", "style");
        safelist.addAttributes("p", "style");
        safelist.addAttributes("article", "style");

        String clean1 = Jsoup.clean(htmlWithWhitespace, safelist);
        System.out.println(forStorage(clean1));

        String clean2 = Jsoup.clean(htmlWithoutWhitespace, safelist);
        System.out.println(clean2);

        System.out.println("====================================");
    }

    public static String forStorage(String htmlStr) {
        return htmlStr.replaceAll(">\\s+<", "><").trim();
    }

    private static void output2(String htmlWithWhitespace, String htmlWithoutWhitespace) {
        String forStorage1 = forStorage(htmlWithWhitespace);
        System.out.println(forStorage1);

        String forStorage2 = forStorage(htmlWithoutWhitespace);
        System.out.println(forStorage2);

        System.out.println("====================================");

        String hashWithWhitespace = getMd5Hash(htmlWithWhitespace);
        String hashWithoutWhitespace = getMd5Hash(htmlWithoutWhitespace);

        System.out.println("原始HTML比較:");
        System.out.println("有空白的MD5: " + hashWithWhitespace);
        System.out.println("無空白的MD5: " + hashWithoutWhitespace);
        System.out.println("雜湊值相同? " + hashWithWhitespace.equals(hashWithoutWhitespace));

        System.out.println("====================================");

        String normalizedWithWhitespace = normalizeHtmlContent(htmlWithWhitespace);
        System.out.println(normalizedWithWhitespace);

        System.out.println("====================================");

        String normalizedWithoutWhitespace = normalizeHtmlContent(htmlWithoutWhitespace);
        System.out.println(normalizedWithoutWhitespace);

        String hashNormalizedWithWhitespace = getMd5Hash(normalizedWithWhitespace);
        String hashNormalizedWithoutWhitespace = getMd5Hash(normalizedWithoutWhitespace);



        System.out.println("====================================");

        System.out.println("規範化後HTML比較:");
        System.out.println("規範化後的有空白HTML: " + normalizedWithWhitespace.substring(0, 50) + "...");
        System.out.println("規範化後的無空白HTML: " + normalizedWithoutWhitespace.substring(0, 50) + "...");
        System.out.println("規範化後有空白的MD5: " + hashNormalizedWithWhitespace);
        System.out.println("規範化後無空白的MD5: " + hashNormalizedWithoutWhitespace);
        System.out.println("規範化後雜湊值相同? " + hashNormalizedWithWhitespace.equals(hashNormalizedWithoutWhitespace));
    }

    private static void output1(String htmlWithWhitespace, String htmlWithoutWhitespace) {
        String htmlStr1 = normalizeHtml(htmlWithWhitespace);
        System.out.println(htmlStr1);
        System.out.println("====================================");
        String htmlStr2 = normalizeHtml(htmlWithoutWhitespace);
        System.out.println(htmlStr2);
    }

    public static String normalizeHtml(String html) {
        Document doc = Jsoup.parse(html);

        doc.outputSettings()
                .indentAmount(0)
                .prettyPrint(false)  // 禁用美化格式
                .escapeMode(Entities.EscapeMode.xhtml);

        return doc.html();
    }

    public static String normalizeHtmlContent(String html) {
        Document doc = Jsoup.parse(html);
        return doc.body().html();
    }

    public static String getMd5Hash(String normalized) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(normalized.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}


package com.lex.practice.jsoup.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class LoadURL {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://example.com/").get();
        System.out.println(doc);

        System.out.println("======================================================================================");

        String title = doc.title();
        System.out.println(title);

        System.out.println("======================================================================================");

        Document doc2 = Jsoup.connect("https://example.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();

        System.out.println(doc2);
    }
}

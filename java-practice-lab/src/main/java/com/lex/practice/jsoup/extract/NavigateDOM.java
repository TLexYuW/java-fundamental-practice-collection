package com.lex.practice.jsoup.extract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class NavigateDOM {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/demo.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Element content = doc.getElementById("content");
        System.out.println(content);

        System.out.println("================================================================================");

        Elements links = content.getElementsByTag("a");
        System.out.println(links);

        System.out.println("================================================================================");

        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();

            System.out.println(linkHref);

            System.out.println("================================================================================");

            System.out.println(linkText);
        }
    }
}

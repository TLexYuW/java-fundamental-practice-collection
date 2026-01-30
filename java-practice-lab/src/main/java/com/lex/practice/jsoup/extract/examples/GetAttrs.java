package com.lex.practice.jsoup.extract.examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Objects;

/**
 * @author : Lex Yu
 */
public class GetAttrs {
    public static void main(String[] args) {
        String html = "<h1 data-seq=\"1\">標題</h1>" +
                "<p data-seq=\"2\">這是一段文字。</p>" +
                "<ul data-seq=\"3\">" +
                "<li>項目 1</li>" +
                "<li>項目 2</li>" +
                "</ul>" +
                "<p data-seq=\"4\">這是最後一段文字。</p>";

        parseHtml(html);
    }

    public static void parseHtml(String html) {
        Document doc = Jsoup.parse(html);

        for (Element element : doc.select("[data-seq]")) {
            String orderId = element.attr("data-seq");

            String elementHtml = element.outerHtml();

            System.out.println("Order ID: " + orderId);
            System.out.println("Element HTML: " + elementHtml);
            System.out.println("-------------------");
        }
    }
}

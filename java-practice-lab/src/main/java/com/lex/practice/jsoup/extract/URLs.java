package com.lex.practice.jsoup.extract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class URLs {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://jsoup.org").get();

        System.out.println("HTML = \n" + doc);
        Element link = doc.select("a").first();
        String relHref = link.attr("href"); // == "/"
        String absHref = link.attr("abs:href"); // "http://jsoup.org/"
        String absUrl = link.absUrl("href");

        System.out.println("=============================================================================");

        System.out.println("Rel Href = " + relHref);
        System.out.println("Abs Href = " + absHref);
        System.out.println("Abs Url = " + absUrl);
    }
}

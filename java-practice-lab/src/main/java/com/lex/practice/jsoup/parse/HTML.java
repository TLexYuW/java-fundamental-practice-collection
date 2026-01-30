package com.lex.practice.jsoup.parse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class HTML {
    public static void main(String[] args) throws IOException {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc);

        System.out.println("========================================================================================");

        String url = "https://www.nmns.edu.tw/ch/exhibitions/special-exhibitions/Exhibition-000472/";
        Document doc2 = Jsoup.connect(url).get();
        System.out.println(doc2);
    }
}

package com.lex.practice.jsoup.modify;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class SetAttrValue {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/demo.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Elements attr = doc.select("div.comments a").attr("rel", "nofollow");
        System.out.println(attr);
    }
}

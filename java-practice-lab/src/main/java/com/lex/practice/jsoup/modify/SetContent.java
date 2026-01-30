package com.lex.practice.jsoup.modify;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class SetContent {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/demo.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Element selectedDiv = doc.select("div.w").first();
        System.out.println(selectedDiv);
        selectedDiv.text("five > four");
        selectedDiv.prepend("First ");
        selectedDiv.append(" Last");
        System.out.println(selectedDiv);
    }
}

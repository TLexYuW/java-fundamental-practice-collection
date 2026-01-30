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
public class SelectorSyntax {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/demo.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements links = doc.select("a[href]"); // a with href
        System.out.println("Links: " + links);

        System.out.println("==================================================================");

        Elements pngs = doc.select("img[src$=.png]");
        // img with src ending .png
        System.out.println("PNG = " + pngs);

        System.out.println("==================================================================");

        Element masthead = doc.select("div.masthead").first();
        // div with class=masthead
        System.out.println(masthead);

        System.out.println("==================================================================");

        Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
        System.out.println("ResultLinks = " + resultLinks);
    }
}

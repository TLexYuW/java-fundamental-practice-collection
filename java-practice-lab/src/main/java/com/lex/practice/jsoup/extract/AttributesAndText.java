package com.lex.practice.jsoup.extract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class AttributesAndText {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/demo.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Element link = doc.select("a").last();

//        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
//        System.out.println("HTML = " + html);
//        Document doc = Jsoup.parse(html);
//        Element link = doc.select("a").first();
        System.out.println("==================================================================");

        System.out.println("Link = " + link);

        System.out.println("==================================================================");

        String text = doc.body().text(); // "An example link"
        System.out.println("Body Text = " + text);

        System.out.println("==================================================================");

        String linkHref = link.attr("href"); // "http://example.com/"
        String linkText = link.text(); // "example""

        System.out.println("Link Href = " + linkHref);

        System.out.println("==================================================================");

        System.out.println("Link Text = " + linkText);

        System.out.println("==================================================================");

        // "<a href="http://example.com"><b>example</b></a>"
        String linkOuterH = link.outerHtml();
        System.out.println("Link Outer HTML = " + linkOuterH);

        System.out.println("==================================================================");

        String linkInnerH = link.html(); // "<b>example</b>"
        System.out.println("Link Inner HTML = " + linkInnerH);
    }
}

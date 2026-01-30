package com.lex.practice.jsoup.modify;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class SetHtmlElement {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/demo.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        Element lastDiv = doc.select("div").last(); // <div></div>
        lastDiv.html("<p>lorem ipsum</p>"); // <div><p>lorem ipsum</p></div>
        lastDiv.prepend("<p>First</p>");
        lastDiv.append("<p>Last</p>");
        // now: <div><p>First</p><p>lorem ipsum</p><p>Last</p></div>
        System.out.println(lastDiv);

        Element lastSpan = doc.select("span").last(); // <span>One</span>
        lastSpan.wrap("<li><a href='http://example.com/'></a></li>");
        System.out.println(lastSpan);
        Element outerElement = doc.select("li").last();
        System.out.println(outerElement);
        // now: <li><a href="http://example.com"><span>One</span></a></li>
    }
}

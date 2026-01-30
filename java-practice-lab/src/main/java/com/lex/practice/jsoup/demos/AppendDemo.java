package com.lex.practice.jsoup.demos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class AppendDemo {
    public static void main(String[] args) throws IOException {
        File input = new File("src/main/resources/email.html");
        Document doc = Jsoup.parse(input, "UTF-8");
        System.out.println(doc);

        System.out.println("========================================================================================");

        Objects.requireNonNull(doc.getElementById("maintain")).append("<td style=\"text-align: center;\">Test-999</td>");
        System.out.println(doc);
    }
}

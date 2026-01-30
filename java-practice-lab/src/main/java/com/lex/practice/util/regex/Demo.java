package com.lex.practice.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{1,5}$");
        Matcher matcher = pattern.matcher("");
        if (matcher.matches()) {
            System.out.println("Match : " + matcher.group());
        } else {
            System.out.println("Not Match");
        }
    }
}

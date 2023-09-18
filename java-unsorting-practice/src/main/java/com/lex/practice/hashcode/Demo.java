package com.lex.practice.hashcode;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {

        String str1 = "通话";
        String str2 = "重地";
        System.out.printf("str1：%d | str2：%d%n", str1.hashCode(), str2.hashCode());
        System.out.println(str1.equals(str2));
    }
}

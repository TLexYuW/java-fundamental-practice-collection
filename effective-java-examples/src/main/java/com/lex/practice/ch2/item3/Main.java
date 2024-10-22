package com.lex.practice.ch2.item3;

import com.lex.practice.ch2.item3.field.Elvis;

public class Main {
    public static void main(String[] args) {
        // field; This code would normally appear outside the class!
        // Elvis e = new Elvis(); // Elvis() has private access in Elvis
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        // static factory;
        com.lex.practice.ch2.item3.static_factory.Elvis e2 = com.lex.practice.ch2.item3.static_factory.Elvis.getInstance();
        e2.leaveTheBuilding();

        // enum
        com.lex.practice.ch2.item3.enum_type.Elvis e3 = com.lex.practice.ch2.item3.enum_type.Elvis.INSTANCE;
        e3.leaveTheBuilding();
    }
}

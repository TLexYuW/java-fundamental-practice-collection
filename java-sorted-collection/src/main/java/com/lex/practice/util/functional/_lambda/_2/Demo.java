package com.lex.practice.util.functional._lambda._2;

public class Demo {
    public static void main(String[] args) {
        MyFunInterface<ChildC> fun = (childC, msg) -> System.out.println("reading " + msg);

        fun.execute(new ChildC(), "some messages");
    }
}

package com.lex.practice.util.functional._lambda._1;

public class Demo {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.MyInnerFunctionalInterface myFunc = (message) -> System.out.println("Message received: " + message);

        outer.runInnerInterface(myFunc, "Hello from the inner interface!");
    }
}

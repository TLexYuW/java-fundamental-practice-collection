package com.lex.practice.util.functional._lambda._1;

public class Outer {

    @FunctionalInterface
    public interface MyInnerFunctionalInterface {
        void execute(String message);

        default void process(String something) {
            System.out.println(something + " Inside process...");
        }
    }

    public void runInnerInterface(MyInnerFunctionalInterface func, String message) {
        func.execute(message);
    }
}



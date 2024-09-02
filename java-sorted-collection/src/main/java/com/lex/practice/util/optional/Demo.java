package com.lex.practice.util.optional;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        MyClass somejavaobject = null;

        // This will result in an empty string because somejavaobject is null
        String result = Optional.ofNullable(somejavaobject)
                .map(obj -> obj.getSomething())
                .orElse("Null example");

        System.out.println(result);

        // Example where somejavaobject is not null
        somejavaobject = new MyClass();
        somejavaobject.something = "Hello, World!";

        // This will result in "Hello, World!" because somejavaobject is not null and getSomething() returns "Hello, World!"
        result = Optional.ofNullable(somejavaobject)
                .map(obj -> obj.getSomething())
                .orElse("");

        System.out.println(result);
    }

    static class MyClass {
        private String something;

        public String getSomething() {
            return something;
        }
    }

}

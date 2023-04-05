package com.lex.optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // default value
//        Object value = Optional.ofNullable(null)
//                .orElseGet(() -> "default value");
        // Hello
//        Object value = Optional.ofNullable("Hello")
//                .orElseGet(() -> "default value");

        /*
        Supplier<IllegalStateException> exception =
                () -> new IllegalStateException("exception");
        */
//        Object value = Optional.ofNullable(null)
//                .orElseThrow(() -> new IllegalStateException("exception"));
//        System.out.println(value);

        // Sending email to test@gmail.com
        Optional.ofNullable("test@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        // Cannot send email
        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

    }
}

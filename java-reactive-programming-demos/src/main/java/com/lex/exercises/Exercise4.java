package com.lex.exercises;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
//        ReactiveSources.intNumberMono().subscribe(System.out::println);


        // Get the value from the Mono into an integer variable
        // TODO: Write code here
//        Integer num = ReactiveSources.intNumberMono().block();
//        Optional<Integer> num = ReactiveSources.intNumberMono().blockOptional();
//        System.out.println(num);

//        User user = ReactiveSources.userMono().block();
//        System.out.println(user);

        ReactiveSources.intNumberMono().flux().subscribe(
                n -> System.out.println(n),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete")
        );

        System.out.println("Press a key to end");
        System.in.read();
    }

}

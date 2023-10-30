package com.lex.exercises;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        // TODO: Write code here

        ReactiveSources.intNumbersFlux()
                .doOnNext(System.out::println)
                .subscribe();

        ReactiveSources.intNumbersFlux().subscribe(integer -> System.out.println(integer));

        // Print all users in the ReactiveSources.userFlux stream
        // TODO: Write code here
        ReactiveSources.userFlux()
                .doOnNext(System.out::println)
                .subscribe();

        ReactiveSources.userFlux().subscribe(integer -> System.out.println(integer));


        System.out.println("Press a key to end");
        System.in.read();
    }

}

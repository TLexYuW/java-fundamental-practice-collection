package com.lex.exercises;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.usersFlux()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux()
//                .subscribe(
//                        integer -> {
//                            System.out.println(integer);
//                            if (integer == 9) {
//                                throw new RuntimeException();
//                            }
//                        },
//                        err -> System.out.println(err),
//                        () -> System.out.println("Complete")
//                );


        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithoutDelay().subscribe(new MySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1);
    }

    public void hookOnNext(T value) {
//        if (!notOverwhelmed) {
//            System.out.println(value.toString() + " received");
//        }
        System.out.println(value.toString() + " received");
        request(500000000);
    }
}
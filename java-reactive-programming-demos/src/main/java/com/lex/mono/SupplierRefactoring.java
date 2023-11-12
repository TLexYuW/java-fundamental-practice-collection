package com.lex.mono;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.lex.Utils.faker;

/**
 * @author : Lex Yu
 */
public class SupplierRefactoring {
    public static void main(String[] args) {
        String name = getName()
                .log()
//                .subscribeOn(Schedulers.boundedElastic())
//                .subscribeOn(Schedulers.parallel())
                .subscribeOn(Schedulers.single())
                .subscribeOn(Schedulers.newParallel("parallel-worker", 3)) // block forever
//                .block();
                .block();

        System.out.println(name);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");
        return Mono.fromSupplier(() -> {
                    System.out.println("Generating name..");
                    try {
                        System.out.println("Thread Name : " + Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return faker().name().fullName();
                })
                .map(String::toUpperCase);
    }
}

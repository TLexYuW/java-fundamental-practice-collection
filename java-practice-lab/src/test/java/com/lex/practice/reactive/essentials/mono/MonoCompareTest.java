package com.lex.practice.reactive.essentials.mono;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author : Lex Yu
 */
public class MonoCompareTest {

    @Test
    void MonoDefer() throws InterruptedException {
        Mono<Date> mono_just = Mono.just(new Date()).log(); // Declare Step: Create Date Object, and only once
        Mono<Date> mono_defer = Mono.defer(()-> Mono.just(new Date())).log();
        mono_just.subscribe(date -> System.out.println("Just Date = " + date));
        mono_defer.subscribe(date -> System.out.println("Defer Date = " + date));

        Thread.sleep(5000);

        mono_just.subscribe(date -> System.out.println("Just Date = " + date));
        // Subscribe Step: Create Data Object, and every time subscribe() will create Date Object
        mono_defer.subscribe(date -> System.out.println("Defer Date = " + date));

    }
}

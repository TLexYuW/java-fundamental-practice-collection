package com.lex.practice.reactive.context;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * @author : Lex Yu
 */
public class ContextTest {

    @Test
    void context_test_1() {
        String key = "message";
        Mono<String> r = Mono.just("Hello")
                .log()
                .flatMap(string -> {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    System.out.println("String : " + string);
                    System.out.println("=================================================");
                    return Mono.deferContextual(ctx -> {
                        System.out.println("CTX = " + ctx);
                        System.out.println("Thread : " + Thread.currentThread().getName());
                        System.out.println("=================================================");
                        return Mono.just(string + " " + ctx.get(key));
                    });
                })
                .contextWrite(ctx -> {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    System.out.println("CTX = " + ctx);
                    return ctx.put(key, "World");
                });

        StepVerifier.create(r)
                .expectNext("Hello World")
                .verifyComplete();
    }
}

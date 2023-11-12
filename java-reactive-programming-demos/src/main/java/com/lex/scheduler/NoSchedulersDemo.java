package com.lex.scheduler;

import reactor.core.publisher.Flux;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class NoSchedulersDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * [ INFO] (main) | onSubscribe([Fuseable] FluxMapFuseable.MapFuseableSubscriber)
         * [ INFO] (main) | request(unbounded)
         * [ INFO] (main) | onNext(TAIPEI City)
         * [ INFO] (main) | onNext(JAPAN City)
         * [ INFO] (main) | onNext(AMERICA City)
         * [ INFO] (main) | onComplete()
         * main thread
         */
        stringFlux().subscribe();
    }

    public static Flux<String> stringFlux(){
       return Flux.just("Abcdefghijkl", "Taipei", "Japan", "America")
                .map(String::toUpperCase)
                .filter(cityName -> cityName.length() <= 8)
                .map(cityName -> cityName.concat(" City"))
                .log();
    }


}

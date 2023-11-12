package com.lex.scheduler.subscribe_on;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class SubscribeOnDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * [ INFO] (main) onSubscribe(FluxMap.MapSubscriber)
         * [ INFO] (main) request(unbounded)
         * before subscribeOn() map-1 = boundedElastic-1
         * before subscribeOn() map-1 = boundedElastic-1
         * before subscribeOn() map-1 = boundedElastic-1
         * before subscribeOn() map-1 = boundedElastic-1
         * before subscribeOn() filter = boundedElastic-2
         * before subscribeOn() filter = boundedElastic-2
         * before subscribeOn() map-2 = boundedElastic-2
         * concat = boundedElastic-2
         * strToUpperCase = boundedElastic-2
         * [ INFO] (boundedElastic-2) onNext(TAIPEI CITY CITY)
         * [ INFO] (boundedElastic-2) cancel()
         */
        stringFlux().blockFirst();

//        useScribeOn();
    }

    public static Flux<String> stringFlux(){
        return Flux.just("Abcdefghijkl", "Taipei", "Japan", "America")
                .map(s -> {
                    System.out.println("before subscribeOn() map-1 = "+Thread.currentThread().getName());
                    return s;
                })
                .publishOn(Schedulers.boundedElastic())
                .filter(cityName -> {
                    System.out.println("before subscribeOn() filter = "+Thread.currentThread().getName());
                    return cityName.length() <= 8;
                })
                .map(cityName -> {
                    System.out.println("before subscribeOn() map-2 = "+Thread.currentThread().getName());
                    return cityName.concat(" City");
                })
                .subscribeOn(Schedulers.boundedElastic())
                .map(SubscribeOnDemo::concat)
                .map(SubscribeOnDemo::strToUpperCase)
                .log();
    }

    private static String strToUpperCase(String name) {
        System.out.println("strToUpperCase = " + Thread.currentThread().getName());
        return name.toUpperCase();
    }

    private static String concat(String name) {
        System.out.println("concat = " + Thread.currentThread().getName());
        return name.concat(" City");
    }


    public static void useScribeOn() throws IOException, InterruptedException {
        Scheduler scheduler = Schedulers.newParallel("parallel-scheduler", 3);
        Flux<String> fluxDemo = Flux.range(1, 10)
                .map(i -> 100 + i + " <=> " + Thread.currentThread().getName())
                .subscribeOn(scheduler)
                .map(i -> "result = " + i + " <=> " + Thread.currentThread().getName());

        // Always use parallel-scheduler
        new Thread(() -> fluxDemo.subscribe(System.out::println), "Thread X").start();

        System.out.println("Thread = " + Thread.currentThread().getName());

        Thread.sleep(5000);

    }
}

package com.lex.practice.reactive.scheduler.publish_on;

import com.lex.practice.reactive.scheduler.subscribe_on.SubscribeOnDemo;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class PublishOnDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * [ INFO] (main) | onSubscribe([Fuseable] FluxMapFuseable.MapFuseableSubscriber)
         * [ INFO] (main) | request(unbounded)
         * before publishOn() map-1 = main
         * before publishOn() filter = main
         * before publishOn() map-1 = main
         * before publishOn() filter = main
         * before publishOn() map-2 = main
         * before publishOn() map-1 = main
         * before publishOn() filter = main
         * before publishOn() map-2 = main
         * before publishOn() map-1 = main
         * before publishOn() filter = main
         * before publishOn() map-2 = main
         * concat = boundedElastic-1
         * strToUpperCase = boundedElastic-1
         * [ INFO] (boundedElastic-1) | onNext(TAIPEI CITY CITY)
         * [ INFO] (boundedElastic-1) | cancel()
         */
        stringFlux().blockFirst();

        //        usePublishOn();

    }
    public static Flux<String> stringFlux(){
        return Flux.just("Abcdefghijkl", "Taipei", "Japan", "America")
                .map(s -> {
                    System.out.println("before publishOn() map-1 = "+Thread.currentThread().getName());
                    return s;
                })
                .filter(cityName -> {
                    System.out.println("before publishOn() filter = "+Thread.currentThread().getName());
                    return cityName.length() <= 8;
                })
                .map(cityName -> {
                    System.out.println("before publishOn() map-2 = "+Thread.currentThread().getName());

                    return cityName.concat(" City");
                })
                .publishOn(Schedulers.boundedElastic())
                .map(PublishOnDemo::concat)
                .map(PublishOnDemo::strToUpperCase)
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


    public static void usePublishOn() throws IOException, InterruptedException {
        Scheduler scheduler = Schedulers.newParallel("parallel-scheduler", 3);
        Flux<Integer> fluxDemo = Flux.range(1, 10)
                .map(i -> {
                    System.out.println("before publishOn() map: " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(scheduler)
                .map(i -> {
                    System.out.println("after publishOn() map: " + Thread.currentThread().getName());
                    return i;
                });

        // Before publishOn, Use Thread X, After publishOn, Use parallel-scheduler
        new Thread(fluxDemo::subscribe, "Thread X").start();

        System.out.println("Thread = " + Thread.currentThread().getName());

        Thread.sleep(5000);
    }

}

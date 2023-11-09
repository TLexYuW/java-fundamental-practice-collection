package com.lex.flux_mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Lex Yu
 */
public class ReactorSource {

    public static Mono<String> stringMono() {
        return Mono.just("Data");
    }

    public static Flux<Integer> integerFlux() {
        return Flux.just(1, 2, 3, 4, 5);
    }

    public static Flux<String> stringFlux() {
        return Flux.just("Hello", ", ", "World", "!");
    }

    public static Flux<Integer> rangeFlux() {
        return Flux.range(1, 1000);
    }

    public static Flux<Long> intervalFlux() {
        return Flux.interval(Duration.of(1, ChronoUnit.SECONDS));
    }

    public static Integer[] integers() {
        return new Integer[]{1, 2, 3, 4, 5};
    }

    public static List<Integer> integerList() {
        return Arrays.asList(integers());
    }

    public static Stream<Integer> integerStream() {
        return Arrays.stream(integers());
    }


}

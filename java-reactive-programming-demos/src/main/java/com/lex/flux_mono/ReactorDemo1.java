package com.lex.flux_mono;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Lex Yu
 */
public class ReactorDemo1 {
    public static void main(String[] args) {
        ReactorSource.integerFlux().subscribe(System.out::println);

        System.out.println("==============================================");

        ReactorSource.stringFlux().subscribe(System.out::append);

        System.out.println("\n==============================================");
        System.out.println("Array");

        Integer[] integers = ReactorSource.integers();
        Flux.fromArray(integers).subscribe(System.out::println);

        System.out.println("==============================================");
        System.out.println("List");

        List<Integer> integerList = ReactorSource.integerList();
        Flux.fromIterable(integerList).subscribe(System.out::println);

        System.out.println("==============================================");
        System.out.println("Stream");

        Stream<Integer> integerStream = ReactorSource.integerStream();
        Flux.fromStream(integerStream).subscribe(System.out::println);
    }
}

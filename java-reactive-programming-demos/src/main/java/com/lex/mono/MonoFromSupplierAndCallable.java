package com.lex.mono;

import reactor.core.publisher.Mono;

import static com.lex.Utils.faker;

/**
 * @author : Lex Yu
 */
public class MonoFromSupplierAndCallable {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        Mono.fromSupplier(() -> getName()).log().subscribe(o -> System.out.println("fromSupplier Received : " + o));
        Mono.fromSupplier(() -> getNull()).log().subscribe(o -> System.out.println("fromSupplier Received : " + o));
        Mono.fromCallable(() -> getName()).log().subscribe(o -> System.out.println("fromCallable Received : " + o));
        Mono.fromCallable(() -> getNull()).log().subscribe(o -> System.out.println("fromCallable Received : " + o));
        Mono.fromSupplier(() -> "XXX YYY ZZZ").subscribe(o -> System.out.println("Received : " + o));
    }

    private static String getName() {
        System.out.println("Generating name..");
        return faker().name().fullName();
    }

    private static String getNull() {
        return null;
    }
}

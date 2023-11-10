package com.lex.mono;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

import static com.lex.Utils.faker;

/**
 * @author : Lex Yu
 */
public class MonoEmptyOrError {
    public static void main(String[] args) {
        userDataService(1)
                .log()
                .onErrorContinue((throwable, o) -> {
                    System.out.println(throwable.getMessage());
                    System.out.println(o);
                })
                .subscribe(o -> System.out.println("Item Received : " + o),
                        e -> System.out.println("ERROR Consumer : " + e.getMessage()),
                        () -> System.out.println("Complete Consumer"));
    }

    private static Mono<String> userDataService(int userId) {
        if (userId == 1) {
            return Mono.just(faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}

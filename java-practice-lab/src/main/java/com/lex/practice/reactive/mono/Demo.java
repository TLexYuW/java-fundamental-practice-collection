package com.lex.practice.reactive.mono;

import com.lex.practice.reactive.model.User;
import reactor.core.publisher.Mono;

/**
 * @author : Lex Yu
 */
public class Demo {
	public static void main(String[] args) {
//		MonoEmpty().subscribe();

//		MonoError().subscribe();

//		MonoJust().subscribe();

//		MonoJustMethod();

	}

	// empty
	static Mono<Object> MonoEmpty() {
		Mono<Object> emptyMono = Mono.empty().log();
		return emptyMono;
	}

	// error
	static Mono<Object> MonoError() {
		Mono<Object> errorMono = Mono.error(new Exception("Error happened")).log();
		return errorMono;
	}

	// just
	// Takes data as an argument.
	// Data is generated before subscribe.
	static Mono<User> MonoJust() {
		return Mono.just(User.builder().id(10000).firstName("Lex").lastName("Luthor").build()).log();
	}

	static Mono<String> MonoJustMethod() {
		return Mono.just(getMessage()).log();
	}

	private static String getMessage() {
		System.out.println("getMessage() Invoked!");
		return "This is a Message.";
	}

	// defer
	private static Mono<String> MonoDefer() {
		return Mono.defer(() -> {
			return Mono.just(getMessage());
		}).log();
	}

}

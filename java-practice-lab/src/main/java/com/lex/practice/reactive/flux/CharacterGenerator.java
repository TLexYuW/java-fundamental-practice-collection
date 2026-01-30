package com.lex.practice.reactive.flux;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author : Lex Yu
 */
public class CharacterGenerator {
	public static void main(String[] args) {
		generateList()
				.collectList()
				.map(strings -> String.join(",", strings))
				.subscribe(System.out::println);

		System.out.println("==========================================================");

		generateCharacters().subscribe(System.out::println);
	}

	private static Flux<String> generateList() {
		final Random random = new Random();
		return Flux.generate(ArrayList::new, (list, sink) -> {
			int value = random.nextInt(10);
			list.add(value);
			sink.next(String.valueOf(value));
			if (list.size() == 10) {
				sink.complete();
			}
			return list;
		});
	}

	public static Flux<Character> generateCharacters() {

		return Flux.generate(() -> 97, (state, sink) -> {
			char value = (char) state.intValue();
			if (value == 'z') {
				sink.complete();
			} else {
				sink.next(value);
			}
			return state + 1;
		});
	}

}

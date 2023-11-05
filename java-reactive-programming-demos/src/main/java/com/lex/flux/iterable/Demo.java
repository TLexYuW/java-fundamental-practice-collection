package com.lex.flux.iterable;

import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class Demo {
	public static void main(String[] args) {
		Flux.fromIterable(Arrays.asList(1,2,3,4)).subscribe(System.out::println);
	}

}

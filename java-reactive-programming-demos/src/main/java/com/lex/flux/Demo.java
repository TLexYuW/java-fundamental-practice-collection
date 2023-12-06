package com.lex.flux;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;

/**
 * @author : Lex Yu
 */
public class Demo {
	public static void main(String[] args) throws InterruptedException, IOException {
		long start = System.nanoTime();

		Flux.range(1, 5)
				.delayElements(Duration.ofSeconds(2))
				.doOnComplete(() -> {
					long end = System.nanoTime();
					long executionTime = end - start;
					System.out.println("Total execution time: " + (executionTime / 1_000_000_000));
				})
				.subscribe(value -> System.out.println("Flux: " + value));


		System.out.println("Press a key to end");
		System.in.read();
	}
}

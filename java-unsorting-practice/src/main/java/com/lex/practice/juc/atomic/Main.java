package com.lex.practice.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/3/25
 */
public class Main {
	public static void main(String[] args) {
		AtomicReference<String> str = new AtomicReference<>("1");
		str.compareAndSet("TEST","Things");
		System.out.println(str); // output: Things

		str.compareAndSet("Err","NewThings");
		System.out.println(str); // output: Things

		str.compareAndSet("Test","NewThings");
		System.out.println(str); // output: Things

		str.compareAndSet("1","NewThings");
		System.out.println(str); // output: NewThings
	}
}

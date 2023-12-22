package com.lex.oop_refresh.abstraction.abstract_example;

/**
 * @author : Lex Yu
 * @date : 2023/9/4
 */
public class Lion extends Animal {
	public Lion() {
	}

	public Lion(String test) {
		super(test);
	}

	@Override
	public void sound() {
		System.out.println("Roar ~~~");
	}

	@Override
	public void move() {
		System.out.println("Lion Moving...");
	}
}

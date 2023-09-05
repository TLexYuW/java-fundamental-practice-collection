package com.lex.oop_refresh.abstraction.interface_example;

/**
 * @author : Lex Yu
 * @date : 2023/9/4
 */
public interface B {

	// public static final
	String test = "1234567";
	void sample();
	void sum(int x, int y);

	default void canUnimplemented() {
		System.out.println(test);
	}
}

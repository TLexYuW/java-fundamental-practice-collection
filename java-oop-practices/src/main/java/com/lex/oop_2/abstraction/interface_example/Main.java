package com.lex.oop_2.abstraction.interface_example;

/**
 * @author : Lex Yu
 * @date : 2023/9/4
 */
public class Main {
	public static void main(String[] args) {
//		A a = new A(); // 'A' is abstract; cannot be instantiated

		C c = new C();

		c.sample();

		c.sum(2,3);

		c.sum();

		c.canUnimplemented();
	}
}

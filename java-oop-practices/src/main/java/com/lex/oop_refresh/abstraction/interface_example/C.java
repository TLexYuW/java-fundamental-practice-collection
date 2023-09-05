package com.lex.oop_refresh.abstraction.interface_example;

/**
 * @author : Lex Yu
 * @date : 2023/9/4
 */
public class C implements A, B {

	@Override
	public void sample() {
		System.out.println("sample from c");
	}

	@Override
	public void sum(int x, int y) {
		System.out.println((x + y));
	}

	@Override
	public void sum() {
		System.out.println("Empty");
	}

	@Override
	public void canUnimplemented() {
		B.super.canUnimplemented();
	}
}

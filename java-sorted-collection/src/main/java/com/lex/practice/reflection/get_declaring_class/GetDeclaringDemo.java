package com.lex.practice.reflection.get_declaring_class;

import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetDeclaringDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> innerClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPrivateClass");

		System.out.println("innerClass.getDeclaringClass() = " + innerClass.getDeclaringClass().getCanonicalName());
		System.out.println("innerClass.getEnclosingClass() = " + innerClass.getEnclosingClass().getCanonicalName());
	}
}

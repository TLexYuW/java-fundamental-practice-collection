package com.lex.practice.reflection.get_all_public_constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetPublicConstructorsDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		Constructor<?>[] constructors = concreteClass.getConstructors();

		System.out.println(Arrays.toString(constructors));
		// [public com.lex.practice.reflection.base.ConcreteClass(int)]
	}

}

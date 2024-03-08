package com.lex.practice.reflection.get_public_constructor;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetPublicConstructorsDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");
		Constructor<?> constructor = concreteClass.getConstructor(int.class);
		System.out.println(Arrays.toString(constructor.getParameterTypes()));


		Class<?> thread = Class.forName("java.lang.Thread");
		Constructor<?>[] constructors = thread.getConstructors();
		System.out.println(Arrays.toString(constructors));
	}

}

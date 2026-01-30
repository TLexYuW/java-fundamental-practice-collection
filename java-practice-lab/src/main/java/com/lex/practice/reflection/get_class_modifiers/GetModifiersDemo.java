package com.lex.practice.reflection.get_class_modifiers;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetModifiersDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		System.out.println(Modifier.toString(concreteClass.getModifiers()));

		System.out.println(Modifier.toString(
				Class.forName("com.lex.practice.reflection.base.BaseInterface").getModifiers()));

	}

}

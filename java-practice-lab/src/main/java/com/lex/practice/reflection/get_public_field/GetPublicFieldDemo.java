package com.lex.practice.reflection.get_public_field;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetPublicFieldDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		Field interfaceInt = concreteClass.getField("publicInt");

		System.out.println(interfaceInt);
		// public int com.lex.practice.reflection.base.ConcreteClass.publicInt
	}

}

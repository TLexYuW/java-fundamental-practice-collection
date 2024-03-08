package com.lex.practice.reflection.get_all_public_fiels;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetPublicFieldsDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		Field[] fields = concreteClass.getFields();

		System.out.println(Arrays.toString(fields));
		// [public int com.lex.practice.reflection.base.ConcreteClass.publicInt,
		// public static final int com.lex.practice.reflection.base.BaseInterface.baseInterfaceInt,
		// public int com.lex.practice.reflection.base.BaseClass.baseInt]
	}

}

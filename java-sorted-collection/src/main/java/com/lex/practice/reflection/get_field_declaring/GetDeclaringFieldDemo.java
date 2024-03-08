package com.lex.practice.reflection.get_field_declaring;

import java.lang.reflect.Field;

/**
 * @author : Lex Yu
 */
public class GetDeclaringFieldDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

		try {
			Field field = Class.forName("com.lex.practice.reflection.base.ConcreteClass")
					.getField("baseInterfaceInt");

			Class<?> fieldClass = field.getDeclaringClass();
			System.out.println(fieldClass.getCanonicalName());
			// com.lex.practice.reflection.base.BaseInterface
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}

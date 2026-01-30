package com.lex.practice.reflection.get_set_private_field_val;

import com.lex.practice.reflection.base.ConcreteClass;

import java.lang.reflect.Field;

/**
 * @author : Lex Yu
 */
public class GetAndSetFieldDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

		Field privateField = Class.forName("com.lex.practice.reflection.base.ConcreteClass")
				.getDeclaredField("privateString");

		privateField.setAccessible(true);

		ConcreteClass obj = new ConcreteClass(1);
		System.out.println("privateField.get(obj) = " + privateField.get(obj));
		privateField.set(obj, "private string updated");
		System.out.println("After privateField.set(...), then privateField.get(obj) = " + privateField.get(obj));

	}
}

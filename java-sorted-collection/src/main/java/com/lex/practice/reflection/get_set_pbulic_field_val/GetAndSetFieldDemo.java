package com.lex.practice.reflection.get_set_pbulic_field_val;

import com.lex.practice.reflection.base.ConcreteClass;

import java.lang.reflect.Field;

/**
 * @author : Lex Yu
 */
public class GetAndSetFieldDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

		try {
			Field field1 = Class.forName("com.lex.practice.reflection.base.ConcreteClass")
					.getField("publicInt");

			ConcreteClass obj = new ConcreteClass(5);
			System.out.println("use Reflection get ConcreteClass obj publicInt = " + field1.get(obj));
			field1.setInt(obj, 10);
			System.out.println("After use Reflection set ConcreteClass obj publicInt = " + field1.get(obj));

		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}

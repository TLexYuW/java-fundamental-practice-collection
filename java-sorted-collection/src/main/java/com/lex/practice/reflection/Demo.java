package com.lex.practice.reflection;

import com.lex.practice.reflection.base.ConcreteClass;

/**
 * @author : Lex Yu
 */
public class Demo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass = ConcreteClass.class;
		System.out.println("ConcreteClass.class = " + concreteClass);


		concreteClass = new ConcreteClass(5).getClass();
		System.out.println("new ConcreteClass(5).getClass() = " + concreteClass);

		try {
			concreteClass = Class.forName("com.lex.practice.reflection.base.ConcreteClass");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("concreteClass.getCanonicalName() = " + concreteClass.getCanonicalName());


		//for primitive types, wrapper classes and arrays
		Class<?> booleanClass = boolean.class;
		System.out.println("boolean.class = " + booleanClass.getCanonicalName());

		Class<?> cDouble = Double.TYPE;
		System.out.println("Double.TYPE = " + cDouble.getCanonicalName());

		Class<?> cDoubleArray = Class.forName("[D");
		System.out.println("Class.forName(\"[D\"); = " + cDoubleArray.getCanonicalName());

		Class<?> twoDStringArray = String[][].class;
		System.out.println("String[][].class = " + twoDStringArray.getCanonicalName());
	}
}

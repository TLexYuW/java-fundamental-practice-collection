package com.lex.practice.reflection.get_declared_classes;

import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetDeclaredDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		Class<?>[] declaredClasses = concreteClass.getDeclaredClasses();

		/*
		[interface com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPublicInterface,
		 class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPublicEnum,
	     class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassDefaultEnum,
	     class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassDefaultClass,
	     class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassProtectedClass,
	     class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPrivateClass,
	     class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPublicClass]

		 */

		System.out.println(Arrays.toString(declaredClasses));
	}

}

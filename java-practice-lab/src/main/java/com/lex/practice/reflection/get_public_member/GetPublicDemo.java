package com.lex.practice.reflection.get_public_member;

import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetPublicDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");
		Class<?>[] classes = concreteClass.getClasses();

	/*
	 * [interface com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPublicInterface,
	 * class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPublicEnum,
	 * class com.lex.practice.reflection.base.ConcreteClass$ConcreteClassPublicClass,
	 * class com.lex.practice.reflection.base.BaseClass$BaseClassMemberEnum,
	 * class com.lex.practice.reflection.base.BaseClass$BaseClassInnerClass]
	 */
		System.out.println(Arrays.toString(classes));
	}
}

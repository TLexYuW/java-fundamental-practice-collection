package com.lex.practice.reflection.get_super;

/**
 * @author : Lex Yu
 */
public class GetSuperDemo {
	public static void main(String[] args) throws ClassNotFoundException {

		Class<?> superClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass").getSuperclass();

		System.out.println(superClass);
		System.out.println(Object.class.getSuperclass());
		System.out.println(String[][].class.getSuperclass());
	}
}

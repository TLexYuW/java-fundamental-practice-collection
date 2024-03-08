package com.lex.practice.reflection.get_type_parameters;

import java.lang.reflect.TypeVariable;

/**
 * @author : Lex Yu
 */
public class GetTypeParamsDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();

		for (TypeVariable<?> t : typeParameters) {
			System.out.print(t.getName() + " ");
		}

	}

}

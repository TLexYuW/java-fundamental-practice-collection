package com.lex.practice.reflection.get_implemented_interfaces;

import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetImplementedInterface {
	public static void main(String[] args) throws ClassNotFoundException {
		Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();

		// [java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]
		System.out.println(Arrays.toString(interfaces));

		// [interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]
		System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));
	}

}

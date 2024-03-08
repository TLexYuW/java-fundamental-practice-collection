package com.lex.practice.reflection.new_instance_method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : Lex Yu
 */
public class NewInstanceDemo {
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		Object obj = concreteClass.getDeclaredConstructor(int.class).newInstance(1000);
		Method baseMethod1 = obj.getClass().getMethod("baseMethod_1");
		baseMethod1.invoke(obj);

		Constructor<?> hashMapConstructor = Class.forName("java.util.HashMap")
				.getConstructor();
		System.out.println(Arrays.toString(hashMapConstructor.getParameterTypes()));
		HashMap<String, Boolean> myMap = (HashMap<String, Boolean>) hashMapConstructor.newInstance();
	}
}

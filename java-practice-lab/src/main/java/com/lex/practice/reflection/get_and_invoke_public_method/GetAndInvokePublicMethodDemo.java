package com.lex.practice.reflection.get_and_invoke_public_method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lex Yu
 */
public class GetAndInvokePublicMethodDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = Class.forName("java.util.HashMap")
				.getMethod("put", Object.class, Object.class);

		System.out.println(Arrays.toString(method.getParameterTypes()));
		System.out.println(method.getReturnType());
		System.out.println(Modifier.toString(method.getModifiers()));
		// [class java.lang.Object, class java.lang.Object]
		// class java.lang.Object
		// public

		Map<String, String> map = new HashMap<>();

		method.invoke(map, "key1", "value1");

		System.out.println(map);
	}

}

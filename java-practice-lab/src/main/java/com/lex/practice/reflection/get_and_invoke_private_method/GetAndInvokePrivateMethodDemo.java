package com.lex.practice.reflection.get_and_invoke_private_method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Lex Yu
 */
public class GetAndInvokePrivateMethodDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		Method method3 = Class.forName("com.lex.practice.reflection.base.BaseClass")
				.getDeclaredMethod("method3");

		method3.setAccessible(true);

		method3.invoke(null, null);

	}

}

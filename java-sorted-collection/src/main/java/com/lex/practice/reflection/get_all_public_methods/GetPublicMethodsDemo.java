package com.lex.practice.reflection.get_all_public_methods;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetPublicMethodsDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> concreteClass =
				Class.forName("com.lex.practice.reflection.base.ConcreteClass");

		Method[] methods = concreteClass.getMethods();

		// ConcreteClass, BaseClass, Object classes
		//[public int com.lex.practice.reflection.base.ConcreteClass.method4(),
		// public int com.lex.practice.reflection.base.ConcreteClass.method5(int),
		// public void com.lex.practice.reflection.base.ConcreteClass.baseMethod_1(),
		// public int com.lex.practice.reflection.base.ConcreteClass.baseMethod_2(java.lang.String),
		// public static int com.lex.practice.reflection.base.BaseClass.method5(),
		// public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException,
		// public final void java.lang.Object.wait() throws java.lang.InterruptedException,
		// public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException,
		// public boolean java.lang.Object.equals(java.lang.Object),
		// public java.lang.String java.lang.Object.toString(),
		// public native int java.lang.Object.hashCode(),
		// public final native java.lang.Class java.lang.Object.getClass(),
		// public final native void java.lang.Object.notify(),
		// public final native void java.lang.Object.notifyAll()]
		System.out.println(Arrays.toString(methods));

	}

}

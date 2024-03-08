package com.lex.practice.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author : Lex Yu
 */
public class AnnotationDemo {
	public static void main(String[] args) {
		try {
			for (Method method : AnnotationBean.class.getClassLoader()
					.loadClass(("com.lex.practice.annotations.AnnotationBean")).getMethods()) {
				System.out.println("Method = " + method);
				if (method.isAnnotationPresent(com.lex.practice.annotations.MethodInfo.class)) {
					try {
						for (Annotation anno : method.getDeclaredAnnotations()) {
							System.out.println("Annotation in Method '" + method + "' : " + anno);
						}
						MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
						if (methodAnno.revision() == 1) {
							System.out.println("Method with revision no 1 = " + method);
						}

					} catch (Throwable ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		// Annotation in Method 'public java.lang.String com.lex.practice.annotations.AnnotationBean.toString()' : @com.lex.practice.annotations.MethodInfo(author="User2", revision=2, comments="this is override toString Method", date="March 8 2024")
		// Annotation in Method 'public static void com.lex.practice.annotations.AnnotationBean.oldMethod()' : @java.lang.Deprecated(forRemoval=false, since="")
		// Annotation in Method 'public static void com.lex.practice.annotations.AnnotationBean.oldMethod()' : @com.lex.practice.annotations.MethodInfo(author="Tester", revision=1, comments="deprecated method", date="Jan 1 2024")
		// Method with revision no 1 = public static void com.lex.practice.annotations.AnnotationBean.oldMethod()
		// Annotation in Method 'public static void com.lex.practice.annotations.AnnotationBean.genericsTest() throws java.io.FileNotFoundException' : @com.lex.practice.annotations.MethodInfo(author="Pankaj", revision=10, comments="genericsTest method", date="Nov 11 2023")
	}
}

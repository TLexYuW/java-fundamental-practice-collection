package com.lex.practice.reflection.get_all_annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author : Lex Yu
 */
public class GetAnnotationsDemo {
	public static void main(String[] args) throws ClassNotFoundException {

		Annotation[] annotations =
				Class.forName("com.lex.practice.annotations.AnnotationBean").getAnnotations();

		System.out.println(Arrays.toString(annotations));
		// [@jdk.jfr.Timestamp("12346"),
		// @jdk.jfr.Description("Test Annotation")]
	}

}

package com.lex.practice.annotations;

import jdk.jfr.Description;
import jdk.jfr.Timestamp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 */
@Timestamp("12346")
@Description("Test Annotation")
public class AnnotationBean {

	@Override
	@MethodInfo(author = "User2", comments = "this is override toString Method", date = "March 8 2024", revision = 2)
	public String toString() {
		return "Overriden toString method";
	}

	@Deprecated
	@MethodInfo(comments = "deprecated method", date = "Jan 1 2024")
	public static void oldMethod() {
		System.out.println("old method, don't use it.");
	}

	@SuppressWarnings({"unchecked", "deprecation"})
	@MethodInfo(author = "Pankaj", comments = "genericsTest method", date = "Nov 11 2023", revision = 10)
	public static void genericsTest() throws FileNotFoundException {
		List l = new ArrayList();
		l.add("abc");
		oldMethod();
	}
}

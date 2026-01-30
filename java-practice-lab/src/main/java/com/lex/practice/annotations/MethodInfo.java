package com.lex.practice.annotations;

import java.lang.annotation.*;

/**
 * @author : Lex Yu
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
	String author() default "Tester";
	String date();
	int revision() default 1;
	String comments();
}

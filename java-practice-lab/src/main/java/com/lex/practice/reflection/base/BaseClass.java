package com.lex.practice.reflection.base;

/**
 * @author : Lex Yu
 */
public class BaseClass {
	public int baseInt;

	private static void method3() {
		System.out.println("BaseClass Method3");
	}

	public int method4() {
		System.out.println("BaseClass Method4");
		return 0;
	}

	public static int method5() {
		System.out.println("BaseClass Method5");
		return 0;
	}

	void method6() {
		System.out.println("BaseClass Method6");
	}

	// inner public class
	public class BaseClassInnerClass {
	}

	//member public enum
	public enum BaseClassMemberEnum {}
}

package com.lex.practice.reflection.get_package_name;

/**
 * @author : Lex Yu
 */
public class GetPackageDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.printf("""
						Package Name: %s
						""",
				Class.forName("com.lex.practice.reflection.base.ConcreteClass").getPackage().getName());
	}
}

package com.lex.unsorted;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		String name = Categories.MAIN_PAGE.name();
		int value = Categories.MAIN_PAGE.getId();
		String description = Categories.MAIN_PAGE.getSlug();

		System.out.println(name);
		System.out.println(value);
		System.out.println(description);
	}
}

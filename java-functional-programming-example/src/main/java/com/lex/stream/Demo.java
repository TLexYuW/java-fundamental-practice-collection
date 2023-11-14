package com.lex.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 */
public class Demo {
	public static void main(String[] args) {
		List<String> keys = List.of("", "1", "2", "3");

		keys.stream()
				.filter(k -> !k.isEmpty())
				.forEach(k -> System.out.println("Key = " + k));
	}

}

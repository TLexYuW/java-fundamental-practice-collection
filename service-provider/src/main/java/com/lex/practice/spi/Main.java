package com.lex.practice.spi;

import java.util.ServiceLoader;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		LexLogback lexLogback = new LexLogback();
		lexLogback.info("Test info");
		lexLogback.debug("Test debug");

		ServiceLoader<Search> loader = ServiceLoader.load(Search.class);
		for (Search search : loader) {
			search.searchDoc("Hello World");
		}
	}
}

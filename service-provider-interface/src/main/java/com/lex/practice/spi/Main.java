package com.lex.practice.spi;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		LexLoggerService service = LexLoggerService.getService();

		service.info("Hi SPI! info");
		service.debug("Hi SPI! debug");
		/*
		No LexLogger Service Provider in Info
		No LexLogger Service Provider in Debug
		 */
	}
}

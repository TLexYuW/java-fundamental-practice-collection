package com.lex.practice.spi;

/**
 * @author : Lex Yu
 */
public class LexLogback implements LexLogger  {
	public LexLogback() {
	}

	@Override
	public void info(String msg) {
		System.out.println("LexLogback Info = " + msg);
	}

	@Override
	public void debug(String msg) {
		System.out.println("LexLogback Debug = " + msg);
	}
}

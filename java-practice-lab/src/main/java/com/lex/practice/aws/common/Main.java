package com.lex.practice.aws.common;

import java.io.IOException;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		for (int i = 0; i < 10; i++) {
			CommonUtils.writeJsonLog();
			Thread.sleep(3000);
		}
	}
}

package com.lex.practice;

/**
 * @author : Lex Yu
 */
public class Main {
	public static void main(String[] args) {
		int numOfCores = Runtime.getRuntime().availableProcessors();

		System.out.println("numOfCores = " + numOfCores);
	}
}

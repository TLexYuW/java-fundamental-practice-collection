package com.lex.practice.execution_order;

/**
 * @author : Lex Yu
 */
public class StaticBlockExecutionOrder {

	static {
		System.out.println("static block 1");
	}

	static {
		System.out.println("static block 2");
	}


	public static void main(String[] args) {
		System.out.println("Main Method");
	}

}

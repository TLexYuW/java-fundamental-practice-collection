package com.lex.practice.execution_order;

/**
 * @author : Lex Yu
 */
public class ExecutionOrder {
	{
		System.out.println("Instance initializer block 1");
	}

	{
		System.out.println("Instance initializer block 2");
	}

	static {
		System.out.println("static block 1");
	}

	static {
		System.out.println("static block 2");
	}

	public ExecutionOrder() {
		System.out.println("Class Constructor");
	}

	public static void main(String[] args) {
		ExecutionOrder order = new ExecutionOrder();
		System.out.println("Main Method");
	}

}

package com.lex.practice.execution_order;

/**
 * @author : Lex Yu
 */
public class InstanceBlockExecutionOrder {

	{
		System.out.println("Instance initializer block 1");
	}

	{
		System.out.println("Instance initializer block 2");
	}

	public InstanceBlockExecutionOrder() {
		System.out.println("Class constructor");
	}

	public static void main(String[] args) {
		InstanceBlockExecutionOrder instanceBlockExecutionOrder = new InstanceBlockExecutionOrder();

		System.out.println("Main Method");
	}

}

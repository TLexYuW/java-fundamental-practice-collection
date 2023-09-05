package com.lex.oop_refresh.abstraction.abstract_example;

/**
 * @author : Lex Yu
 * @date : 2023/9/4
 */
public abstract class Animal {

	// can have fields
	private String test;

	public Animal() {
	}

	// can have constructor
	public Animal(String test) {
		this.test = "?????";
	}

	public abstract void sound();

	public void move(){
		System.out.println("Moving...");
	}

	public void canUnimplemented(){

	}


}

package com.lex.oop_refresh.composition.eg2;

/**
 * @author : Lex Yu
 * @date : 2023/9/6
 */
public class Car {
	private Engine engine;

	public Car() {
		engine = new Engine(); // Composition: Car "has" an Engine
	}

	public void startCar() {
		engine.start(); // Delegating the start operation to the Engine
	}

	public void stopCar() {
		engine.stop(); // Delegating the stop operation to the Engine
	}
}

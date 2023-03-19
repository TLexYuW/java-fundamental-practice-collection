package com.lex.practice.dynamicPolymorphism;

/**
 * @author : LEX_YU
 * @date : 19/03/2023
 */
public class Dog extends Animal{

    @Override
    public void speak() {
        System.out.println("woof!");
    }
}

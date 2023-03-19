package com.lex.practice.interfaces;

/**
 * @author : LEX_YU
 * @date : 19/03/2023
 */
public class Fish implements Prey, Predator{
    @Override
    public void hunt() {
        System.out.println("The Fish is hunting smaller fish");
    }

    @Override
    public void flee() {
        System.out.println("The Fish is fleeing from bigger fish");
    }
}

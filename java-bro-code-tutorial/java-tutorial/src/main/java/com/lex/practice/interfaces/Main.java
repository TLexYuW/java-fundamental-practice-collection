package com.lex.practice.interfaces;

/**
 * @author : LEX_YU
 * @date : 19/03/2023
 */
public class Main {
    public static void main(String[] args) {
        // interface
        // a template that can be applied to class.
        // similar to inheritance, but specifies what a class has/must do.
        // classes can apply more than one interface, inheritance is limited to 1 super

        Rabbit rabbit = new Rabbit();
        rabbit.flee();
        Hawk hawk = new Hawk();
        hawk.hunt();

        Fish fish = new Fish();
        fish.hunt();
        fish.flee();
    }
}

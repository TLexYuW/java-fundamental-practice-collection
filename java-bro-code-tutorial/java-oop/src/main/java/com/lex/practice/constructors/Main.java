package com.lex.practice.constructors;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 */
public class Main {
    public static void main(String[] args) {

        // constructor = special method that is called when an object is instantiated (created)
        // create different objects, attributes
        Human human1 = new Human("Rick",100,50.00);
        Human human2 = new Human("Rick2",50,70.00);

        System.out.println(human1.name);
        System.out.println(human2.age);

        human1.eat();
        human2.drink();
    }
}

package com.lex.practice.overload;

/**
 * @author : LEX_YU
 * @date : 01/03/2023
 */
public class Main {
    public static void main(String[] args) {
        // overload constructors
        // multiple constructors within a class with the same name
        // but have different parameters
        // name + parameters = signature

        Pizza pizza = new Pizza("thicc crust","tomato","mozzarella","pepperoni");
        System.out.println("Here are the ingredients of your pizza: ");
        System.out.println(pizza.bread);
        System.out.println(pizza.sauce);
        System.out.println(pizza.cheese);
        System.out.println(pizza.topping);

        Pizza pizza2 = new Pizza("thicc crust","tomato","mozzarella");

        Pizza pizza3 = new Pizza("thicc crust","tomato");

        Pizza pizza4 = new Pizza("thicc crust");

        Pizza pizza5 = new Pizza();


    }
}

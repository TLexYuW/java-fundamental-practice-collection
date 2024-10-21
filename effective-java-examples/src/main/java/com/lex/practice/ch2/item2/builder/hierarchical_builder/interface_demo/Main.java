package com.lex.practice.ch2.item2.builder.hierarchical_builder.interface_demo;

public class Main {

    public static void main(String[] args) {
        NyPizza nyPizza = NyPizza.builder()
                .size(NyPizza.Size.LARGE)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = Calzone.builder()
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .sauceInside(true)
                .build();
        System.out.println(nyPizza.toString());
        System.out.println(calzone.toString());

        System.out.println("NY Pizza toppings: " + nyPizza.getToppings());
        System.out.println("Calzone toppings: " + calzone.getToppings());
    }
}

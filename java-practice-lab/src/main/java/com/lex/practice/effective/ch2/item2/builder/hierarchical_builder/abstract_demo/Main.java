package com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.abstract_demo;

import static com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.abstract_demo.NyPizza.Size.SMALL;
import static com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.abstract_demo.Pizza.Topping.HAM;
import static com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.abstract_demo.Pizza.Topping.ONION;
import static com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.abstract_demo.Pizza.Topping.SAUSAGE;

public class Main {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM)
                .sauceInside()
                .build();

        System.out.println(pizza.toString());
        System.out.println(calzone.toString());
    }
}

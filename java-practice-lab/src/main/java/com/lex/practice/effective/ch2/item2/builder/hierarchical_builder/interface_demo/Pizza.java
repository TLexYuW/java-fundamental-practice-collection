package com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.interface_demo;

import java.util.Set;

public interface Pizza {

    enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    Set<Topping> getToppings();
}

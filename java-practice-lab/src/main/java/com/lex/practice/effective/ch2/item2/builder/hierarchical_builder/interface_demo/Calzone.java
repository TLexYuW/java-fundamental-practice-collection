package com.lex.practice.effective.ch2.item2.builder.hierarchical_builder.interface_demo;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Calzone implements Pizza {

    private final Set<Topping> toppings;
    private final boolean sauceInside;

    private Calzone(Set<Topping> toppings, boolean sauceInside) {
        this.toppings = EnumSet.copyOf(toppings);
        this.sauceInside = sauceInside;
    }

    @Override
    public String toString() {
        return "Calzone [getToppings()=" + getToppings() + ", isSauceInside()=" + isSauceInside() + "]";
    }

    @Override
    public Set<Topping> getToppings() {
        return Collections.unmodifiableSet(toppings);
    }

    public boolean isSauceInside() {
        return sauceInside;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        private boolean sauceInside = false;

        private Builder() {
        }

        public Builder addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return this;
        }

        public Builder sauceInside(boolean sauceInside) {
            this.sauceInside = sauceInside;
            return this;
        }

        public Calzone build() {
            return new Calzone(toppings, sauceInside);
        }
    }
}

package com.lex.practice.ch2.item2.builder.hierarchical_builder.interface_demo;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class NyPizza implements Pizza {

    private final Set<Topping> toppings;
    private final Size size;

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private NyPizza(Set<Topping> toppings, Size size) {
        this.toppings = EnumSet.copyOf(toppings);
        this.size = size;
    }

    @Override
    public String toString() {
        return "NyPizza [getToppings()=" + getToppings() + ", getSize()=" + getSize() + "]";
    }

    @Override
    public Set<Topping> getToppings() {
        return Collections.unmodifiableSet(toppings);
    }

    public Size getSize() {
        return size;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        private Size size;

        private Builder() {
        }

        public Builder addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return this;
        }

        public Builder size(Size size) {
            this.size = Objects.requireNonNull(size);
            return this;
        }

        public NyPizza build() {
            return new NyPizza(toppings, Objects.requireNonNull(size));
        }
    }
}

package com.lex.practice.ch2.item2.builder.hierarchical_builder.abstract_demo;

import java.util.Objects;

public class NyPizza extends Pizza {

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public Size getSize() {
        return size;
    }

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public NyPizza(Builder builder) {
        super(builder);
        this.size = builder.size;
    }

    @Override
    public String toString() {
        return "New York Pizza with " + toppings + " (Size: " + getSize() + ")";
    }
}

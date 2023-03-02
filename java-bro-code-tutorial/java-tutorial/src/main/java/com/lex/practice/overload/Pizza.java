package com.lex.practice.overload;

/**
 * @author : LEX_YU
 * @date : 02/03/2023
 */
public class Pizza {
    String bread;
    String sauce;
    String cheese;
    String topping;

    public Pizza() {
    }

    public Pizza(String bread) {
        this.bread = bread;
    }

    public Pizza(String bread, String sauce) {
        this.bread = bread;
        this.sauce = sauce;
    }

    public Pizza(String bread, String sauce, String cheese) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
    }

    public Pizza(String bread, String sauce, String cheese, String topping) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
        this.topping = topping;
    }
}

package com.lex.version_17.sealed;

/**
 * @author : Lex Yu
 */
public class GrayParrot extends Parrot {

    public void sing() {
        System.out.printf("%s is singing\n", this.getClass().getSimpleName());
    }
}

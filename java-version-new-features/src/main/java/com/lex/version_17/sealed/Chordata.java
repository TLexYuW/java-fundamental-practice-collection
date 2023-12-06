package com.lex.version_17.sealed;

/**
 * @author : Lex Yu
 */
public sealed class Chordata implements Animal permits Bird {
    @Override
    public void eat() {
        System.out.printf("%s is Eating\n", this.getClass().getSimpleName());
    }
}

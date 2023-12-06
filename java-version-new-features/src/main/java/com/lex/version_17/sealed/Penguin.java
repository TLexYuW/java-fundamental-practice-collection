package com.lex.version_17.sealed;

/**
 * @author : Lex Yu
 */
public final class Penguin extends Bird {

    @Override
    public void fly() {
        System.out.printf("%s can't fly\n", this.getClass().getSimpleName());
    }

    public void walk() {
        System.out.printf("%s is walking\n", this.getClass().getSimpleName());
    }

    public void swim() {
        System.out.printf("%s is swimming\n", this.getClass().getSimpleName());
    }

}

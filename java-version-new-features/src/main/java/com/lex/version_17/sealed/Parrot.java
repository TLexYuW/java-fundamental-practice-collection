package com.lex.version_17.sealed;

/**
 * @author : Lex Yu
 */
public non-sealed class Parrot extends Bird {

    public void talk(){
        System.out.printf("%s is talking\n", this.getClass().getSimpleName());
    }
}

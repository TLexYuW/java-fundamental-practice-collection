package com.lex.version_17.sealed;

/**
 * @author : Lex Yu
 */
public sealed class Bird extends Chordata permits Parrot, Penguin {

    public void fly(){
        System.out.printf("%s is flying\n", this.getClass().getSimpleName());
    }
}

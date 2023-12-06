package com.lex.version_17.sealed;

/**
 * @author : Lex Yu
 */
public sealed interface Animal permits Chordata {
    void eat();
}

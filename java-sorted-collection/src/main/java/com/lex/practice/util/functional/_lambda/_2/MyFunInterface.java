package com.lex.practice.util.functional._lambda._2;

@FunctionalInterface
public interface MyFunInterface<T extends ParentC> {
    void execute(T someClass, String msg);
}

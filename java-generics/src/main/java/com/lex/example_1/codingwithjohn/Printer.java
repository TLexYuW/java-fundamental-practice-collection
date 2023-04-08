package com.lex.example_1.codingwithjohn;

public class Printer<T> {

    T numToPrint;

    public Printer(T numToPrint) {
        this.numToPrint = numToPrint;
    }

    public void print(){
        System.out.println(numToPrint);
    }
}

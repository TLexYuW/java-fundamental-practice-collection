package com.lex.examples.codingwithjohn;

public class Main {
    public static void main(String[] args) {
        IntegerPrinter specificPrinter = new IntegerPrinter(23);
        specificPrinter.print();

        Printer<Double> printer = new Printer<>(23.0);
        printer.print();

        Printer<Integer> printer1 = new Printer<>(23);
        printer1.print();

    }
}
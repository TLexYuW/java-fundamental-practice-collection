package com.lex.unsorted.fuctionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier_ {
    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionURLsSupplier.get());

    }

    static Supplier<List<String>> getDBConnectionURLsSupplier =
            () -> List.of(
                    "jdbc://localhost:3306/users",
                    "jdbc://localhost:3306/customers"
            );

    static String getDBConnectionURL(){
        return "jdbc://localhost:3306/users";
    }
}

package com.lex.consumer;

import com.lex.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : Lex Yu
 */
public class Demo1 {
    public static void main(String[] args) {
        Product product = new Product("iPhone 13");

        // Lambda
        Consumer<Product> consumer = p -> Product.printSpecial(p);
        consumer.accept(product);

        // Method Ref
        Consumer<Product> consumer1 = Product::printSpecial;
        consumer1.accept(product);

        // Both
        List<Product> products = Arrays.asList(
                new Product("iPhone 13"),
                new Product("iPad Air"),
                new Product("MacBook Pro")
        );

        products.stream()
                .map(Product::printSpecial)
                .forEach(System.out::println);

    }
}

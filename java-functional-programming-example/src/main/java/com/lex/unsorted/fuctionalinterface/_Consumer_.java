package com.lex.unsorted.fuctionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer_ {
    public static void main(String[] args) {
        Customer lex = new Customer("Lex","666666");
        greetCustomer(lex);

        greetCustomerV2(lex, false);

        // Consumer Functional interface
        greetCustomerConsumer.accept(lex);

        greetCustomerBiConsumer.accept(lex, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer =
            ((customer, showPhoneNumber) ->
                    System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number "
                            + (showPhoneNumber ? customer.customerPhoneNumber : "*********")));

    static Consumer<Customer> greetCustomerConsumer =
            customer ->  System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number " + customer.customerPhoneNumber);

    // greetCustomer same as greetCustomerConsumer
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName
        + ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber){
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}

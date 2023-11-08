package com.lex.unsorted.combinatorpattern;

import java.time.LocalDate;
import static com.lex.unsorted.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Test01","test@gmail.com","+0898787879887",
                LocalDate.of(3000,1,1)
                );
//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid, we can store customer in db
        // Using combinator pattern
        // lazy
//        CustomerRegistrationValidator validator  =
//                isEmailValid()
//                        .and(isPhoneNumberValid())
//                        .and(isAdult());

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}

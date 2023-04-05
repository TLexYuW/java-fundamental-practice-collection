package com.lex.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.logging.Logger;

import static com.lex.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

@FunctionalInterface
public interface CustomerRegistrationValidator
        extends Function<Customer, CustomerRegistrationValidator.ValidationResult> {

    static Logger log = Logger.getLogger(CustomerRegistrationValidator.class.getName());

    static CustomerRegistrationValidator isEmailValid(){
        return customer -> {
            log.config("Running email validation");
//            System.out.println("Running email validation");
            return customer.getEmail().contains("@")
                    ? SUCCESS : EMAIL_NOT_VALID;
        };
    }


    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+0")
                ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult(){
        return customer -> Period.between(customer.getBirth(), LocalDate.now()).getYears() > 18
                ? SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT;
    }
}

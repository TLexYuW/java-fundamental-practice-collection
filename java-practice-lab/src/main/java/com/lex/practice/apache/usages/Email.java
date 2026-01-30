package com.lex.practice.apache.usages;

import org.apache.commons.validator.routines.EmailValidator;

public class Email {
    public static void main(String[] args) {
        String email1 = "user@example.com";
        String email2 = "invalid-email@";
        String email3 = "user@localhost";

        EmailValidator v1 = EmailValidator.getInstance();
        EmailValidator v2 = EmailValidator.getInstance(true);

        System.out.println(email1 + " is valid? " + v1.isValid(email1)); // true
        System.out.println(email2 + " is valid? " + v1.isValid(email2)); // false
        System.out.println(email3 + " is valid? " + v1.isValid(email3)); // false (預設不允許 localhost)
        System.out.println(email3 + " is valid? " + v2.isValid(email3)); // trie (允許 localhost)
    }
}

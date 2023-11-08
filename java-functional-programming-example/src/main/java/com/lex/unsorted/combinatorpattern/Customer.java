package com.lex.unsorted.combinatorpattern;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate birth;

    public Customer(String name, String email, String phoneNumber, LocalDate birth) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirth() {
        return birth;
    }
}

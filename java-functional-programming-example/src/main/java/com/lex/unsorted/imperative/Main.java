package com.lex.unsorted.imperative;

import java.util.ArrayList;
import java.util.List;

import static com.lex.unsorted.imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );
        // IMPERATIVE APPROACH
        List<Person> females = new ArrayList<>();
        for (Person p : people) {
            if (FEMALE.equals(p.gender)){
                females.add(p);
            }
        }
        for (Person f : females) {
            System.out.println(f);
        }

        System.out.println("======================================================");

        // Declarative approach
        people.stream()
                .filter(person -> FEMALE.equals(person.gender)) // filter(Predicate)
//                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE,FEMALE;
    }
}
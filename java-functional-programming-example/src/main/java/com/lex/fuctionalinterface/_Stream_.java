package com.lex.fuctionalinterface;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.lex.fuctionalinterface._Stream_.Gender.*;

public class _Stream_ {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Test", FEMALE)
        );

        /*
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);
        */
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
//                .collect(Collectors.toSet())
                .forEach(System.out::println);

        /*
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
         */
        boolean containsOnlyFemale = people.stream()
                .noneMatch(person -> NONE.equals(person.gender));
//                .anyMatch(person -> FEMALE.equals(person.gender));
//                .allMatch(personPredicate);
        System.out.println(containsOnlyFemale);

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
        MALE,FEMALE,NONE;
    }
}

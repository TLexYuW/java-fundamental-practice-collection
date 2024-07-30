package com.lex.practice.util.collections.maps.merge;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MergeDemo3 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Alice", 35),
                new Person("Bob", 28)
        );

        Map<String, Person> personMap = people.stream()
                .collect(Collectors.toMap(
                        person -> person.name, // keyMapper: use the person's name
                        person -> person,      // valueMapper: use the person object itself
                        (p1, p2) -> new Person(p1.name, Math.max(p1.age, p2.age)) // mergeFunction: keep the person with the maximum age
                ));

        System.out.println(personMap);
        // Output: {Alice=Alice:35, Bob=Bob:28}
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + ":" + age;
        }
    }
}

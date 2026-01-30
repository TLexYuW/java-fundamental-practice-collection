package com.lex.practice.util.stream.demos.none_match;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<P_> people = Arrays.asList(
                new P_("Alice", Arrays.asList("student", "gamer")),
                new P_("Bob", Arrays.asList("professional", "parent")),
                new P_("Charlie", Arrays.asList("student", "outdoor"))
        );

        List<String> disallowedTags = Arrays.asList("gamer", "outdoor");

        List<P_> filteredPeople = people.stream()
                .filter(person -> person.getTags().stream()
                        .noneMatch(disallowedTags::contains))
                .toList();

        filteredPeople.forEach(person -> System.out.println(person.getName()));
    }
}

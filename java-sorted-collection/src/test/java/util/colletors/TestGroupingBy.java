package util.colletors;

import com.lex.practice.util.collectors.grouping_by.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestGroupingBy {
    private List<Person> people;

    @BeforeEach
    public void setUp() {
        people = generatePeople();
    }

    @Test
    @DisplayName("Grouping By Age")
    public void test1() {
        Map<Integer, List<Person>> groupedByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        groupedByAge.forEach((age, persons) -> {
            System.out.println("Age: " + age);
            persons.forEach(System.out::println);
        });
    }

    @Test
    @DisplayName("Grouping By Length")
    public void test2() {
        Map<Integer, List<Person>> groupedByNameLength = people.stream()
                .collect(Collectors.groupingBy(person -> person.getName().length()));

        groupedByNameLength.forEach((length, persons) -> {
            System.out.println("Name Length: " + length);
            persons.forEach(System.out::println);
        });
    }

    @Test
    @DisplayName("Grouped By Age And Count")
    public void test3() {
        Map<Integer, Long> groupedByAgeAndCount = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

        groupedByAgeAndCount.forEach((age, count) -> {
            System.out.println("Age: " + age + ", Count: " + count);
        });
    }

    @Test
    @DisplayName("Collecting To Set")
    public void test4() {
        Map<Integer, Set<String>> groupedByAgeAndNames = people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toSet())));

        groupedByAgeAndNames.forEach((age, names) -> {
            System.out.println("Age: " + age + ", Names: " + names);
        });
    }

    @Test
    @DisplayName("Collecting To List With Custom Supplier")
    public void test5() {
        Map<Integer, List<String>> groupedByAgeAndNamesCustomSupplier = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        HashMap::new,
                        Collectors.mapping(Person::getName, Collectors.toList())));

        groupedByAgeAndNamesCustomSupplier.forEach((age, names) -> {
            System.out.println("Age: " + age + ", Names: " + names);
        });
    }

    @Test
    @DisplayName("Collecting To Map")
    public void test6() {
        Map<Integer, Map<String, Integer>> groupedByAgeAndNamesMap = people.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.toMap(Person::getName, Person::getAge)));
        groupedByAgeAndNamesMap.forEach((age, nameAgeMap) -> {
            System.out.println("Age: " + age + ", Name-Age Map: " + nameAgeMap);
        });
    }

    @Test
    @DisplayName("Collecting to TreeMap")
    public void test7() {
        Map<Integer, TreeMap<String, Integer>> groupedByAgeAndNamesTreeMap = people.stream()
                .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.toMap(
                                        Person::getName,
                                        Person::getAge,
                                        (a, b) -> a, TreeMap::new
                                )
                        )
                );

        groupedByAgeAndNamesTreeMap.forEach((age, nameAgeMap) -> {
            System.out.println("Age: " + age + ", Name-Age TreeMap: " + nameAgeMap);
        });
    }

    @Test
    @DisplayName("Collecting to LinkedHashMap")
    public void test8() {
        Map<Integer, LinkedHashMap<String, Integer>> groupedByAgeAndNamesLinkedHashMap = people.stream()
                .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.toMap(
                                        Person::getName,
                                        Person::getAge,
                                        (a, b) -> a,
                                        LinkedHashMap::new
                                )
                        )
                );

        groupedByAgeAndNamesLinkedHashMap.forEach((age, nameAgeMap) -> {
            System.out.println("Age: " + age + ", Name-Age LinkedHashMap: " + nameAgeMap);
        });
    }

    @Test
    @DisplayName("Custom Merge Function")
    public void test9() {
        List<Person> ps = List.of(
                new Person("Alice", 30),
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("Charlie", 30),
                new Person("David", 25),
                new Person("David", 25),
                new Person("Eve", 35),
                new Person("Eve", 35)
        );
        Map<Integer, Map<String, Integer>> groupedByAgeAndNamesCustomCollectorCustomMerge = ps.stream()
                .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.toMap(
                                        Person::getName,
                                        Person::getAge,
                                        Integer::sum // (a, b) -> a + b
                                )
                        )
                );

        groupedByAgeAndNamesCustomCollectorCustomMerge.forEach((age, nameAgeMap) -> {
            System.out.println("Age: " + age + ", Name-Age Map: " + nameAgeMap);
        });
    }

    public static List<Person> generatePeople() {
        return List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30),
                new Person("David", 25),
                new Person("Eve", 35)
        );
    }
}

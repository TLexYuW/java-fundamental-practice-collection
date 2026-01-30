package com.lex.practice.util.collectors.nullsLast;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("Toyota", 1),
                new Car("Honda", null),
                new Car("Ford", 2),
                new Car("BMW", null),
                new Car("Tesla", 3)
        );

        cars.sort(Comparator.comparing(
                        Car::getCategoryId,
                        Comparator.nullsLast(Comparator.naturalOrder())
                )
        );

        cars.forEach(System.out::println);
    }
}

@Data
class Car {
    private String name;
    private Integer categoryId;

    public Car(String name, Integer categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }
}
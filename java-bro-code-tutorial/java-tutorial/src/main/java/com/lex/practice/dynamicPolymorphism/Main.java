package com.lex.practice.dynamicPolymorphism;

import java.util.Scanner;

/**
 * @author : LEX_YU
 * @date : 19/03/2023
 */
public class Main {
    public static void main(String[] args) {
        // polymorphism = many shapes/forms
        // dynamics = after compilation(during runtime)
        // ex: A corvette is a corvette, a car , a vehicle, and an object
        Scanner scanner = new Scanner(System.in);
        Animal animal;

        System.out.println("What animal do u want?");
        System.out.println("(1=dog) or (2=cat): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            animal = new Dog();
            animal.speak();
        } else if (choice == 2) {
            animal = new Cat();
            animal.speak();
        } else {
            animal = new Animal();
            animal.speak();
            System.out.println("Invalid choice");
        }
    }
}

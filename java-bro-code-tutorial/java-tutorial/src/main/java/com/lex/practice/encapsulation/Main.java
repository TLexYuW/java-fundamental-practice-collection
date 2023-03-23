package com.lex.practice.encapsulation;

/**
 * @author : LEX_YU
 * @date : 23/03/2023
 */
public class Main {
    public static void main(String[] args) {
        // Encapsulation
        // attributes of a class will be hidden or private,
        // Can be accessed only through methods (getters & setters)
        // You should make attributes private if you don't have a reason to make them public/protected

        Car car = new Car("Model X","Tesla",2023);
//        System.out.println(car.make);
        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

//        car.year = 2022;
        car.setYear(2022);

        System.out.println(car);


    }
}

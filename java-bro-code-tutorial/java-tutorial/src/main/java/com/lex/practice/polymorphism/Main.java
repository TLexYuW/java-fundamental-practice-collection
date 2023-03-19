package com.lex.practice.polymorphism;

/**
 * @author : LEX_YU
 * @date : 19/03/2023
 */
public class Main {
    public static void main(String[] args) {
        // polymorphism
        // greek word for poly-"many", morph-"form"
        // The ability of an object to identify as more than one type
        Car car = new Car();
        Bike bike = new Bike();
        Motorcycle motorcycle = new Motorcycle();

        Vehicle[] racers = {car, bike, motorcycle};

//        car.go();
//        bike.go();
//        motorcycle.go();

        for (Vehicle v: racers) {
            v.go();
        }
    }
}

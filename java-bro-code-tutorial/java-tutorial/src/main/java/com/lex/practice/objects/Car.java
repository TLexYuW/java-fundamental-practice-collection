package com.lex.practice.objects;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 */
public class Car {
    // Not Practical
    public String make = "Tesla";
    public String model = "Model X";
    int year = 2022;
    String color = "white";
    double price = 110_000.00;

    public void drive(){
        System.out.println("Driving the car");
    }

    public void brake(){
        System.out.println("Step on the brakes");
    }
}

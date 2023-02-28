package com.lex.practice.objects;

import com.lex.practice.constructors.Human;
import com.lex.practice.objects.Car;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 */
public class Main {
    public static void main(String[] args) {
        // object = an instance of a class that may contain attributes and methods
        Car myCar = new Car();
        System.out.println(myCar);
        System.out.println(myCar.model);
        myCar.drive();
        myCar.brake();
    }
}

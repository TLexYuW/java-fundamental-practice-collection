package com.lex.practice.scope;

import java.util.Random;

/**
 * @author : LEX_YU
 * @date : 01/03/2023
 */
public class DiceRoller {
    // global
    // declared outside a method, but within a class
    // visible to all parts of a class
    Random random;
    int number;
    DiceRoller() {
        random = new Random();
        roll();

        // local
        // declared inside a method
        // visible only to method
//        Random random = new Random();
//        int number = 0;
//        roll(random, number);
    }

//    void roll(Random random, int number) {
//        number = random.nextInt(5) + 1;
//        System.out.println(number);
//    }
    void roll() {
        number = random.nextInt(5) + 1;
        System.out.println(number);
    }
}

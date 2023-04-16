package com.lex.practice.enumeration;

/**
 * @author : Lex Yu
 * @date : 16/04/2023
 */
public enum Planet {
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9);

    final int number;

    Planet(int number) {
        this.number = number;
    }
}

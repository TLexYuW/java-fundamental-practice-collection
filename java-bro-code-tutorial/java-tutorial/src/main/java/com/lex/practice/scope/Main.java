package com.lex.practice.scope;

import java.util.Random;

/**
 * @author : LEX_YU
 * @date : 28/02/2023
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            DiceRoller diceRoller = new DiceRoller();
        }
    }
}

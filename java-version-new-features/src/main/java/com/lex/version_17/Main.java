package com.lex.version_17;

import com.lex.version_17.sealed.*;

/**
 * @author : Lex Yu
 * 增強的偽隨機數產生器 : pseudorandom number generator(PRNG)，又稱為 確定性隨機位元產生器
 * Before JDK17 : Random, ThreadLocalRandom, SplittableRandom
 * Sealed Classes
 */
public class Main {
    public static void main(String[] args) {
        var chordata = new Chordata();
        chordata.eat();

        var bird = new Bird();
        bird.fly();
        bird.eat();

        var parrot = new Parrot();
        parrot.talk();
        parrot.fly();
        parrot.eat();

        var grayParrot = new GrayParrot();
        grayParrot.sing();
        grayParrot.fly();
        grayParrot.eat();
        grayParrot.talk();

        var penguin = new Penguin();
        penguin.fly();
        penguin.swim();
        penguin.walk();
        penguin.eat();

    }
}

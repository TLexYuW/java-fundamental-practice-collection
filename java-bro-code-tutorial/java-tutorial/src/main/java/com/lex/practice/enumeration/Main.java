package com.lex.practice.enumeration;

/**
 * @author : LEX_YU
 * @date : 16/04/2023
 */
public class Main {
    public static void main(String[] args) {
        // enum
        // enumerated
        // ordered listing of items in a collection
        // grouping of constants that behave similarly to objects

//        Planet myPlanet = new Planet(); // error

        Planet myPlanet = Planet.EARTH;

        canILiveHere(myPlanet);


    }

    static void canILiveHere(Planet myPlanet){
        switch (myPlanet){
            case EARTH -> {
                System.out.println("You can live here !!");
                System.out.println("This is planet #" +  myPlanet.number);
            }
            default -> {
                System.out.println("You can't live here !!");
                System.out.println("This is planet #" +  myPlanet.number);
            }
        }
    }
}

package com.lex.practice.reactive.observer;

import java.util.Observable;

/**
 * @author : Lex Yu
 */
public class ObservableThing extends Observable {
    public static void main(String[] args) {
        ObservableThing thing = new ObservableThing();

        thing.addObserver(((o, arg) -> {
            System.out.println("A - Data has changed!");
        }));

        thing.addObserver(((o, arg) -> {
            System.out.println("B - Data has changed!");
        }));

        thing.setChanged();
        thing.notifyObservers();
    }
}

package com.lex.practice.encapsulation;

/**
 * @author : LEX_YU
 * @date : 23/03/2023
 */
public class Car {
    private String model;
    private String make;
    private int year;

    public Car(String model, String make, int year) {
        this.setModel(model);
        this.setMake(make);
        this.setYear(year);
//        this.model = model;
//        this.make = make;
//        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

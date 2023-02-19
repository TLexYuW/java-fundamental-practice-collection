package com.lex.basic;

import java.util.ArrayList;
import java.util.List;

public class EnumIteration {
    enum Days{
        SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
    }

    public static void main(String[] args) {
        final EnumIteration enumIteration = new EnumIteration();
        enumIteration.iterate();
    }

    public void iterate(){
        Days[] days = Days.values();
        for (Days day : days) {
            System.out.println(day);
//            System.out.println(day.getClass());
        }

        System.out.println("=============================");

        List<String> stringDays = new ArrayList<>();
        for (Days day : days) {
            stringDays.add(day.toString());
        }
        for (String day: stringDays) {
            System.out.println(day);
//            System.out.println(day.getClass());
        }
    }
}

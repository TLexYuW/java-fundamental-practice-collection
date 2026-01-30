package com.lex.practice.times.localdate.begin_end;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static LocalDateTime getStartOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    public static LocalDateTime getEndOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(LocalTime.of(23,59,59));
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime startOfDay = getStartOfDay(now);
        LocalDateTime endOfDay = getEndOfDay(now);

        System.out.println("Start of Day: " + startOfDay);
        System.out.println("End of Day: " + endOfDay);
    }
}

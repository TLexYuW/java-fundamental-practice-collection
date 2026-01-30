package com.lex.practice.times.localdate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getDatesBetweenOutput();
    }

    public static void getDatesBetweenOutput() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("2024-01-01", formatter);
        LocalDate endDate = LocalDate.parse("2024-01-07", formatter);

        List<LocalDate> datess = getDatesBetween(startDate, endDate);

        for (LocalDate date : datess) {
            System.out.println(date);
        }
    }

    private static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate current = startDate;

        while (!current.isAfter(endDate)) {
            dates.add(current);
            current = current.plusDays(1);
        }

        return dates;
    }
}

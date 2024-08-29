package com.lex.practice.times.localdate.range;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComputeRangeDates {
    public static void main(String[] args) {
        List<LocalDate> localDates = computeDateRange(LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 1, 10));
        System.out.println(localDates);

    }
    private static List<LocalDate> computeDateRange(LocalDate startDate, LocalDate endDate) {
        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(startDate, endDate) + 1)
                .collect(Collectors.toList());
    }
}

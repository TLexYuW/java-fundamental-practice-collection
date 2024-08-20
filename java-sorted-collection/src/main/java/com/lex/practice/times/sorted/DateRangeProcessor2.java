package com.lex.practice.times.sorted;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateRangeProcessor2 {

    public static List<Date> processDateRanges(List<String> dateStrings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        List<LocalDate> dates = dateStrings.stream()
                .map(ds -> LocalDate.parse(ds, formatter))
                .sorted()
                .toList();

        System.out.println("After Sorted dates = " + dates);

        List<LocalDate> result = new ArrayList<>();
        LocalDate rangeStart = null;
        LocalDate rangeEnd = null;

        for (int i = 0; i < dates.size(); i++) {
            LocalDate currentDate = dates.get(i);

            if (rangeStart == null) {
                rangeStart = currentDate;
                rangeEnd = currentDate;
            } else if (rangeEnd.plusDays(1).equals(currentDate)) {
                rangeEnd = currentDate;
            } else {
                result.add(rangeStart);
                if (!rangeStart.equals(rangeEnd)) {
                    result.add(rangeEnd);
                }
                rangeStart = currentDate;
                rangeEnd = currentDate;
            }

            if (i == dates.size() - 1) {
                result.add(rangeStart);
                if (!rangeStart.equals(rangeEnd)) {
                    result.add(rangeEnd);
                }
            }
        }

        // Convert LocalDate to Date
        return result.stream()
                .map(ld -> Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .toList();
    }

    public static void main(String[] args) {
        List<String> dates = List.of(
                "20241227", "20241228", "20241229", "20241230", "20241231",
                "20250101", "20250110", "20250114", "20250115", "20250116",
                "20250117", "20250118", "20250228"
        );

        List<Date> processedDates = processDateRanges(dates);
        System.out.println("results dates: " + processedDates);
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        for (int i = 0; i < processedDates.size(); i += 2) {
//            LocalDate start = processedDates.get(i).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            if (i + 1 < processedDates.size()) {
//                LocalDate end = processedDates.get(i + 1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                System.out.println(start.format(outputFormatter) + "~" + end.format(outputFormatter));
//            } else {
//                System.out.println(start.format(outputFormatter));
//            }
//        }
    }
}

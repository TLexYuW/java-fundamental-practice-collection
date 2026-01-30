package com.lex.practice.times.sorted;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DateProcessor {
    public static void main(String[] args) {
        List<String> dateStrings = List.of(
                "20241227", "20241228", "20241229", "20241230", "20241231",
                "20250101", "20250110", "20250114", "20250115", "20250116",
                "20250117", "20250118", "20250228"
        );

        DateProcessor processor = new DateProcessor();
        String result = processor.processDates(dateStrings);
        System.out.println(result); // Outputs: 2024-12-27~2025-01-01, 2025-01-10, 2025-01-14~2025-01-18, 2025-02-28
    }

    public String processDates(List<String> dateStrings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<LocalDate> dates = dateStrings.stream()
                .map(date -> LocalDate.parse(date, formatter))
                .sorted()
                .collect(Collectors.toList());

        return groupAndFormatDates(dates, outputFormatter);
//        return formatDates(dates);
    }

//    private String formatDates(List<LocalDate> dates) {
//        Collections.sort(dates);
//
//        List<String> formattedDateGroups = new ArrayList<>();
//        List<LocalDate> tempGroup = new ArrayList<>();
//
//        for (LocalDate date : dates) {
//            if (tempGroup.isEmpty()) {
//                tempGroup.add(date);
//            } else {
//                if (date.minusDays(1).equals(tempGroup.get(tempGroup.size() - 1))) {
//                    tempGroup.add(date);
//                } else {
//                    formattedDateGroups.add(formatGroup(tempGroup));
//                    tempGroup.clear();
//                    tempGroup.add(date);
//                }
//            }
//        }
//
//        if (!tempGroup.isEmpty()) {
//            formattedDateGroups.add(formatGroup(tempGroup));
//        }
//
//        return String.join(", ", formattedDateGroups);
//    }
//
//    private String formatGroup(List<LocalDate> group) {
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        if (group.size() > 1) {
//            return group.get(0).format(outputFormatter) + " ~ " + group.get(group.size() - 1).format(outputFormatter);
//        } else {
//            return group.get(0).format(outputFormatter);
//        }
//    }


    private String groupAndFormatDates(List<LocalDate> dates, DateTimeFormatter formatter) {
        List<String> formattedDateGroups = new ArrayList<>();

        for (int i = 0; i < dates.size(); ) {
            int start = i;

            // Find the end of the consecutive date range
            while (i < dates.size() - 1 && dates.get(i).plusDays(1).equals(dates.get(i + 1))) {
                i++;
            }

            // Format the group
            if (start == i) {
                // Single date
                formattedDateGroups.add(dates.get(i).format(formatter));
            } else {
                // Range of dates
                formattedDateGroups.add(dates.get(start).format(formatter) + "~" + dates.get(i).format(formatter));
            }

            i++; // Move to the next date
        }

        return String.join(", ", formattedDateGroups);
    }
}

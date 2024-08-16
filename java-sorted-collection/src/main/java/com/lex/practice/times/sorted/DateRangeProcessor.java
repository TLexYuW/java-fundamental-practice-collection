package com.lex.practice.times.sorted;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DateRangeProcessor {
    public static List<Date> processDateRanges(List<String> dateStrings) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");

        List<Date> dates = new ArrayList<>();
        for (String dateStr : dateStrings) {
            dates.add(inputFormat.parse(dateStr));
        }

        Collections.sort(dates);
        System.out.println("Collections sort dates = " + dates);

        List<Date> result = new ArrayList<>();
        Date rangeStart = null;
        Date rangeEnd = null;

        for (int i = 0; i < dates.size(); i++) {
            Date currentDate = dates.get(i);

            if (rangeStart == null) {
                rangeStart = currentDate;
                rangeEnd = currentDate;
            } else if (isConsecutive(rangeEnd, currentDate)) {
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

        return result;
    }

    private static boolean isConsecutive(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) == 24 * 60 * 60 * 1000;
    }

    public static void main(String[] args) throws ParseException {
        List<String> dates = List.of(
                "20241227", "20241228", "20241229", "20241230", "20241231",
                "20250101", "20250110", "20250114", "20250115", "20250116",
                "20250117", "20250118", "20250228"
        );

        List<Date> processedDates = processDateRanges(dates);

        System.out.println(processedDates);

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < processedDates.size(); i += 2) {
            if (i + 1 < processedDates.size()) {
                System.out.println(outputFormat.format(processedDates.get(i)) +
                        "~" +
                        outputFormat.format(processedDates.get(i + 1)));
            } else {
                System.out.println(outputFormat.format(processedDates.get(i)));
            }
        }
    }
}

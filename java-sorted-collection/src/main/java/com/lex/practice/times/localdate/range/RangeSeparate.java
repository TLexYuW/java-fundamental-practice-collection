package com.lex.practice.times.localdate.range;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RangeSeparate {


    public static void main(String[] args) {
        // Example JSON input as a string
        String jsonString = "{ \"From\": \"2024-08-01T12:00:00\", \"To\": \"2024-08-15T12:00:00\" }";

        // Extract the "From" and "To" values using basic string manipulation
        String fromDateTimeStr = jsonString.split("\"From\": \"")[1].split("\"")[0];
        String toDateTimeStr = jsonString.split("\"To\": \"")[1].split("\"")[0];

        // Parse the extracted datetime strings into LocalDateTime
        LocalDateTime fromDateTime = LocalDateTime.parse(fromDateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime toDateTime = LocalDateTime.parse(toDateTimeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        // Convert LocalDateTime to LocalDate
        LocalDate fromDate = fromDateTime.toLocalDate();
        LocalDate toDate = toDateTime.toLocalDate();

        // Generate the list of dates from fromDate to toDate (inclusive)
        List<String> dateList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        while (!fromDate.isAfter(toDate)) {
            // Format and add the date to the list
            dateList.add(fromDate.format(formatter));
            // Move to the next day
            fromDate = fromDate.plusDays(1);
        }

        // Output the result
        dateList.forEach(System.out::println);
    }

}

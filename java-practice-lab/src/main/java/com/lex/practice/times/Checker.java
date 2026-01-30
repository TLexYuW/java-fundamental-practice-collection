package com.lex.practice.times;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author : Lex Yu
 */
public class Checker {

    enum HolidayType {
        FOUR_HOLIDAY,
        FIVE_HOLIDAY,
        SIX_HOLIDAY,
        // Add more types as needed
    }

    static class DateRange {
        private final LocalDate startDate;
        private final LocalDate endDate;

        public DateRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        @Override
        public String toString() {
            return "{" +
                    "startDate:" + startDate +
                    ", endDate:" + endDate +
                    '}';
        }
    }

    // New class representing a holiday record from the database
    static class HolidayRecord {
        private final LocalDate date;
        private final String type;
        private final String status;

        public HolidayRecord(LocalDate date, String type, String status) {
            this.date = date;
            this.type = type;
            this.status = status;
        }

        public LocalDate getDate() {
            return date;
        }

        public String getType() {
            return type;
        }

        public String getStatus() {
            return status;
        }
    }

    public static void main(String[] args) {
        // Simulate querying from a database
        List<HolidayRecord> holidayRecords = queryHolidayRecordsFromDatabase();

        // Process the records to detect and group continuous holidays
        Map<HolidayType, List<DateRange>> holidayMap = findAndGroupContinuousHolidays(holidayRecords);

        // Print the results
        for (Map.Entry<HolidayType, List<DateRange>> entry : holidayMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    // Simulated method to query holiday records from a database
    private static List<HolidayRecord> queryHolidayRecordsFromDatabase() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return List.of(
                new HolidayRecord(LocalDate.parse("20240914", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20240915", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20240917", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20240921", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20240922", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20240928", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20240929", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241005", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241006", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241010", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241012", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241013", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241019", formatter), "NORMAL", "HOLIDAY"),
                new HolidayRecord(LocalDate.parse("20241020", formatter), "NORMAL", "HOLIDAY")
        );
    }

    // Method to find and group continuous holidays
    private static Map<HolidayType, List<DateRange>> findAndGroupContinuousHolidays(List<HolidayRecord> holidayRecords) {
        List<LocalDate> holidays = new ArrayList<>();

        for (HolidayRecord record : holidayRecords) {
            if ("HOLIDAY".equals(record.getStatus())) {
                holidays.add(record.getDate());
            }
        }

        Collections.sort(holidays); // Ensure the dates are sorted

        Map<HolidayType, List<DateRange>> holidayMap = new HashMap<>();
        List<LocalDate> currentRange = new ArrayList<>();

        for (int i = 0; i < holidays.size(); i++) {
            if (currentRange.isEmpty()) {
                currentRange.add(holidays.get(i));
            } else {
                LocalDate lastDateInRange = currentRange.get(currentRange.size() - 1);
                if (holidays.get(i).equals(lastDateInRange.plusDays(1)) || holidays.get(i).equals(lastDateInRange.plusDays(2))) {
                    currentRange.add(holidays.get(i));
                } else {
                    classifyAndAddHolidayRange(holidayMap, currentRange);
                    currentRange.clear();
                    currentRange.add(holidays.get(i));
                }
            }
        }

        // Handle the last range
        if (!currentRange.isEmpty()) {
            classifyAndAddHolidayRange(holidayMap, currentRange);
        }

        return holidayMap;
    }

    // Method to classify and add the holiday range to the map
    private static void classifyAndAddHolidayRange(Map<HolidayType, List<DateRange>> holidayMap, List<LocalDate> range) {
        int days = range.size() + (range.size() - 1); // Include intervening days

        HolidayType type = null;
        switch (days) {
            case 4:
                type = HolidayType.FOUR_HOLIDAY;
                break;
            case 5:
                type = HolidayType.FIVE_HOLIDAY;
                break;
            case 6:
                type = HolidayType.SIX_HOLIDAY;
                break;
            // Add more cases as needed
        }

        if (type != null) {
            DateRange dateRange = new DateRange(range.get(0), range.get(range.size() - 1));
            holidayMap.computeIfAbsent(type, k -> new ArrayList<>()).add(dateRange);
        }
    }
}

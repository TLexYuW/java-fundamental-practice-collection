package com.lex.practice.times.outdated.date;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getDatesBetweenOutput();
    }

    public static void getDatesBetweenOutput() {
        Date s = Date.valueOf("2024-01-01");
        Date e = Date.valueOf("2024-01-03");

        List<Date> dates = getDatesBetween(s, e);

        for (Date date : dates) {
            System.out.println(date);
        }
    }

    private static List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (!calendar.getTime().after(endDate)) {
            dates.add(new Date(calendar.getTimeInMillis()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dates;
    }
}

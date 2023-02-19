package com.lex.practice;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author : LEX_YU
 * @date : 08/01/2023 12:41 am
 */
public class ExampleDate {
    public static void main(String[] args) {

        // dates
        LocalDate ld = LocalDate.of(2023, Month.FEBRUARY, 28);
        System.out.println(ld);
        ld = ld.plusDays(1);
        System.out.println(ld);
        ld = ld.plusMonths(5);
        System.out.println(ld);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MMM dd");
        System.out.println(ld.format(dtf));
        System.out.println(dtf.format(ld));

        // times
        LocalTime lt = LocalTime.of(12, 30);
        System.out.println(lt);

        // date and times
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt);

        // zoned date and times
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Asia/Taipei"));
        System.out.println(zdt);
    }

}

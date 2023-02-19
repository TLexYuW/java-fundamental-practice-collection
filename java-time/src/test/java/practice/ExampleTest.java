package practice;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author : LEX_YU
 * @date : 08/01/2023 1:48 pm
 */
public class ExampleTest {

    @Test
    public void testDate(){
        Date date1 = new Date(2020-1900, 9-1, 8);
        System.out.println(date1);
    }

    /*
    LocalDate, LocalTime, LocalDateTime
    immutable
    */

    @Test
    public void test1(){
        // now(): 取得 當前日期、時間、日期+時間
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt + "\n");

        // of():
        LocalDateTime ldt1 = LocalDateTime.of(2023, 10, 31, 10, 10, 10);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(ldt1.format(dtf) + "\n");

        // get???()
        System.out.println(ldt.getYear());
        System.out.println(ldt.getDayOfYear());
        System.out.println(ldt.getMonth());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getDayOfWeek());
        System.out.println(ldt.getMinute() + "\n");

        // with???()
        System.out.println(ldt);
        LocalDateTime ldt2 = ldt.withDayOfMonth(31);
        System.out.println(ldt2 + "\n");

        // +-
        System.out.println(ldt.plusMonths(3));
        System.out.println(ldt + "\n");

        // compareTo
        System.out.println(ldt2.compareTo(ldt) + "\n");

        // Duration
        Duration duration = Duration.between(ldt,ldt1);
        System.out.println(duration.toDays());

        long days = ChronoUnit.DAYS.between(ldt, ldt1);
        System.out.println(days);



    }


}

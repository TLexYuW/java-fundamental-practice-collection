package com.lex.practice.casual.date_diff;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class DateDiffDemo {

    static class LoginHistory {
        private Date creDate;

        public LoginHistory(Date creDate) {
            this.creDate = creDate;
        }

        public Date getCreDate() {
            return creDate;
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 模擬最早的創建日期：2025-09-01 03:39:21
        Date earliestDate = sdf.parse("2025-09-01 03:39:21");

        // 模擬今天 2025-09-09 下午
        Date today1 = sdf.parse("2025-09-09 14:00:00"); // 下午2點
        Date today2 = sdf.parse("2025-09-09 15:39:20"); // 接近原時間
        Date today3 = sdf.parse("2025-09-09 15:39:22"); // 稍微超過

        System.out.println("=== 原始程式碼邏輯測試 ===");
        System.out.println("最早日期: " + sdf.format(earliestDate));
        System.out.println();

        testDateDiff("今天 14:00", earliestDate, today1);
        testDateDiff("今天 15:39:20", earliestDate, today2);
        testDateDiff("今天 15:39:22", earliestDate, today3);

        // 額外測試：看看臨界點
        Date boundary = new Date(earliestDate.getTime() + TimeUnit.DAYS.toMillis(7));
        Date justOver = new Date(earliestDate.getTime() + TimeUnit.DAYS.toMillis(7) + 1);

        System.out.println("\n=== 臨界點測試 ===");
        testDateDiff("剛好7天後", earliestDate, boundary);
        testDateDiff("超過7天1毫秒", earliestDate, justOver);
    }

    private static void testDateDiff(String label, Date earliest, Date today) {
        System.out.println("--- " + label + " ---");
        System.out.println("今天時間: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(today));

        long diffTime = today.getTime() - earliest.getTime();
        long days = TimeUnit.MILLISECONDS.toDays(diffTime);
        double exactDays = diffTime / (1000.0 * 60 * 60 * 24);

        System.out.println("時間差(毫秒): " + diffTime);
        System.out.println("天數(整數): " + days);
        System.out.println("天數(精確): " + String.format("%.6f", exactDays));
        System.out.println("days > 7L ? " + (days > 7L));
        System.out.println("會噴Exception? " + (days > 7L ? "是" : "否"));
        System.out.println();
    }
}

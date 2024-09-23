package com.lex.practice.ds.tree.treeset._1;

import java.time.LocalDate;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        // 初始化 TreeSet
        TreeSet<LocalDate> dates = new TreeSet<>();
        dates.add(LocalDate.of(2024, 9, 19));
        dates.add(LocalDate.of(2024, 9, 21));
        dates.add(LocalDate.of(2024, 9, 22));
        dates.add(LocalDate.of(2024, 9, 28));
        dates.add(LocalDate.of(2024, 9, 30));
        dates.add(LocalDate.of(2024, 10, 10));

        // 搜索範圍
        LocalDate startDate = LocalDate.of(2024, 9, 27);
        LocalDate endDate = LocalDate.of(2024, 9, 30);

        // 查找在範圍內的日期 (包含startDate和endDate)
        TreeSet<LocalDate> filteredDates = new TreeSet<>(dates.subSet(startDate, true, endDate, true));

        // 判斷範圍內是否有日期
        if (!filteredDates.isEmpty()) {
            System.out.println("範圍內存在日期: " + filteredDates);
        } else {
            System.out.println("範圍內沒有日期");
        }
    }
}

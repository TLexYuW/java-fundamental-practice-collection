package com.lex.practice.times.localdate.compare;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Compare {
    public static void main(String[] args) {
        Set<List<LocalDate>> holidayGroups = new HashSet<>();
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2024, 2, 7), LocalDate.of(2024, 2, 8), LocalDate.of(2024, 2, 9),
                LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 12),
                LocalDate.of(2024, 2, 13), LocalDate.of(2024, 2, 14))));
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2025, 1, 24), LocalDate.of(2025, 1, 25), LocalDate.of(2025, 1, 26),
                LocalDate.of(2025, 1, 27), LocalDate.of(2025, 1, 28), LocalDate.of(2025, 1, 29),
                LocalDate.of(2025, 1, 30), LocalDate.of(2025, 1, 31), LocalDate.of(2025, 2, 1),
                LocalDate.of(2025, 2, 2))));
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2024, 4, 3), LocalDate.of(2024, 4, 4), LocalDate.of(2024, 4, 5),
                LocalDate.of(2024, 4, 6), LocalDate.of(2024, 4, 7))));
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2024, 10, 9), LocalDate.of(2024, 10, 10), LocalDate.of(2024, 10, 11),
                LocalDate.of(2024, 10, 12), LocalDate.of(2024, 10, 13))));
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2024, 6, 7), LocalDate.of(2024, 6, 8), LocalDate.of(2024, 6, 9),
                LocalDate.of(2024, 6, 10))));
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2023, 12, 29), LocalDate.of(2023, 12, 30), LocalDate.of(2023, 12, 31),
                LocalDate.of(2024, 1, 1))));
        holidayGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2024, 9, 13), LocalDate.of(2024, 9, 14), LocalDate.of(2024, 9, 15),
                LocalDate.of(2024, 9, 16), LocalDate.of(2024, 9, 17))));

        Set<List<LocalDate>> festivalGroups = new HashSet<>();
        festivalGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2024, 2, 7), LocalDate.of(2024, 2, 8), LocalDate.of(2024, 2, 9),
                LocalDate.of(2024, 2, 10), LocalDate.of(2024, 2, 11), LocalDate.of(2024, 2, 12),
                LocalDate.of(2024, 2, 13), LocalDate.of(2024, 2, 14))));
        festivalGroups.add(new ArrayList<>(List.of(
                LocalDate.of(2025, 1, 24), LocalDate.of(2025, 1, 25), LocalDate.of(2025, 1, 26),
                LocalDate.of(2025, 1, 27), LocalDate.of(2025, 1, 28), LocalDate.of(2025, 1, 29),
                LocalDate.of(2025, 1, 30), LocalDate.of(2025, 1, 31), LocalDate.of(2025, 2, 1),
                LocalDate.of(2025, 2, 2))));

        holidayGroups.removeIf(festivalGroups::contains);

        System.out.println("Updated holidayGroups:");
        for (List<LocalDate> group : holidayGroups) {
            System.out.println(group);
        }
    }
}

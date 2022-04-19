package com.javarush.task.pro.task16.task1607;

import com.sun.source.tree.WhileLoopTree;

import java.time.LocalDate;

/*
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        return LocalDate.now();
    }

    static LocalDate ofExample() {
        return LocalDate.of(2020, 9, 12);
    }

    static LocalDate ofYearDayExample() {
        LocalDate destDate = LocalDate.of(2020, 9, 12);
        LocalDate yearBegin = LocalDate.of(2020, 1, 1);
        int daysCount = 1;
        while (yearBegin.isBefore(destDate)) {
            yearBegin = yearBegin.plusDays(1);
            daysCount++;
        }
        return LocalDate.ofYearDay(2020, daysCount);
    }

    static LocalDate ofEpochDayExample() {
        LocalDate destDate = LocalDate.of(2020, 9, 12);
        LocalDate epochBegin = LocalDate.of(1970, 1, 1);
        int daysCount = 0;
        while (epochBegin.isBefore(destDate)) {
            epochBegin = epochBegin.plusDays(1);
            daysCount++;
        }
        return LocalDate.ofEpochDay(daysCount);
    }
}































package com.javarush.task.pro.task16.task1612;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/*
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {

        HashSet<LocalDateTime> setLocalDateTime = new HashSet<>();
        for (Map.Entry entry:sourceMap.entrySet()) {
            LocalDate localDate = (LocalDate) entry.getKey();
            for (LocalTime localTime: (List<LocalTime>) entry.getValue()) {
                LocalDateTime newDateTime = LocalDateTime.of(localDate, localTime);
                setLocalDateTime.add(newDateTime);
            }
        }
        return setLocalDateTime;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}






























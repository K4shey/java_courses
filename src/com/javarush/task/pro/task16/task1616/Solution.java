package com.javarush.task.pro.task16.task1616;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;

/*
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        TreeSet<String> sortedZones = new TreeSet<>();
        for (String zoneId:ZoneId.getAvailableZoneIds()) {
            sortedZones.add(zoneId);
        }
        return sortedZones;
    }

    static ZonedDateTime getBeijingDateTime() {
        for (String zoneId: ZoneId.getAvailableZoneIds()) {
            if (zoneId.equals("Asia/Shanghai")) {
                return ZonedDateTime.now(ZoneId.of(zoneId));
            }
        }
        return null;
    }
}































package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(80,02, 07);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.forLanguageTag("ru"));
        return simpleDateFormat.format(date);
    }
}































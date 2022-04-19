package com.javarush.task.pro.task16.task1604;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1980,8, 1);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        switch (calendar.get(calendar.DAY_OF_WEEK)){
            case 1: return  "Воскресенье";
            case 2: return "Понедельник";
            case 3: return "Вторник";
            case 4: return "Среда";
            case 5: return "Четверг";
            case 6: return "Пятница";
            case 7: return "Суббота";
        }
        return "";
    }
}































package com.javarush.task.pro.task16.task1605;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*
Карманный телепорт
*/

public class Solution {

    public static final String INVENTED = "Пожалуйста, можете забрать ваш карманный телепорт. Спасибо за ожидание!";
    public static final String NOT_INVENTED = "Извините, телепорт еще не изобрели, приходите через 10 лет.";

    public static final Calendar INVENTION_DAY = new GregorianCalendar(2192, Calendar.JUNE, 12);

    public static void main(String[] args) {
        Calendar currentDay = Calendar.getInstance();
        while (!isTeleportInvented(currentDay)) {
            currentDay.add(Calendar.YEAR, 10);
        }
    }

    static boolean isTeleportInvented(Calendar currentDay) {
        if (currentDay.compareTo(INVENTION_DAY) < 0) {
                System.out.println(NOT_INVENTED);
                return false;
        } else {
            System.out.println(INVENTED);
            return true;
        }
    }
}































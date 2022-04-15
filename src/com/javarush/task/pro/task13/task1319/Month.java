package com.javarush.task.pro.task13.task1319;

/*
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths()
    {
        Month[] array = new Month[3];
        array[0] = Month.values()[11];
        System.arraycopy(Month.values(), 0, array, 1, 2);
        return array;
    }

    public static Month[] getSpringMonths()
    {
        Month[] array = new Month[3];
        System.arraycopy(Month.values(), 2, array, 0, 3);
        return array;

    }

    public static Month[] getSummerMonths()
    {
        Month[] array = new Month[3];
        System.arraycopy(Month.values(), 5, array, 0, 3);
        return array;
    }

    public static Month[] getAutumnMonths()
    {
        Month[] array = new Month[3];
        System.arraycopy(Month.values(), 8, array, 0, 3);
        return array;
    }


}































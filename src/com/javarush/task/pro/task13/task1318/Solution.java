package com.javarush.task.pro.task13.task1318;

/*
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
//        System.out.println(getNextMonth(Month.DECEMBER));
    }

    public static Month getNextMonth(Month month) {
        int monthOrd = month.ordinal();
        if (monthOrd == Month.values().length - 1) {
            return Month.values()[0];
        }
        else {
            return Month.values()[++monthOrd];
        }
    }
}































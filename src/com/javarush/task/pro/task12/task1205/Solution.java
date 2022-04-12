package com.javarush.task.pro.task12.task1205;

/*
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
//        divide(Double.POSITIVE_INFINITY, 1);
//        divide(Double.NEGATIVE_INFINITY, -1);
        divide(-1, 0);
//        divide(Double.NEGATIVE_INFINITY, 1);
//        divide(Double.POSITIVE_INFINITY, -1);
        divide(0, 0);
//        divide(1, Double.NaN);
//        divide(Double.NaN, 1);
//        divide(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
//        divide(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
//        divide(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
//        divide(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        System.out.println(Double.valueOf(a) / Double.valueOf(b));
    }
}































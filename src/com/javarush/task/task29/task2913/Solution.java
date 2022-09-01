package com.javarush.task.task29.task2913;

import java.util.Random;

/*
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder result = new StringBuilder();
        if (a < b) {
            for (int i = a; i <= b; i++) {
                result.append(i);
                if (i < b) {
                    result.append(" ");
                }
            }
            return result.toString();
        } else if (a > b) {
            for (int i = a; i >= b; i--) {
                result.append(i);
                if (i > b) {
                    result.append(" ");
                }
            }
            return result.toString();
        } else {
            return Integer.toString(a);
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}






























package com.javarush.task.task22.task2202;

/*
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] arrayOfWords = string.split(" ");
        if (arrayOfWords.length < 5) {
            throw new TooShortStringException();
        }
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= 4; i++) {
            if (i < 4) {
                result.append(arrayOfWords[i]).append(" ");
            } else {
                result.append(arrayOfWords[i]);
            }
        }

        return result.toString();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}































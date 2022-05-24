package com.javarush.task.task22.task2203;

/*
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null) {
            throw new TooShortStringException();
        }

        int firstOccurrence = string.indexOf('\t');
        int secondOccurrence = string.indexOf('\t', firstOccurrence + 1);
        if (firstOccurrence == -1 || secondOccurrence == -1) {
            throw new TooShortStringException();
        }
        return string.substring(firstOccurrence + 1, secondOccurrence);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}































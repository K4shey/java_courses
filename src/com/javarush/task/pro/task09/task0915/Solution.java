package com.javarush.task.pro.task09.task0915;

/*
StringTokenizer
*/

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer myTokenizer = new StringTokenizer(query, delimiter);
        String[] array = new String [myTokenizer.countTokens()];
        int index = 0;
        while (myTokenizer.hasMoreTokens()) {
            array[index++] = myTokenizer.nextToken();
        }
        return array;
    }
}


package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                nextLine = nextLine.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
            }
//            Pattern pattern = Pattern.compile("\\b[0-9]+");
//            Matcher matcher = pattern.matcher(nextLine);
//            while (matcher.find()) {
//                String result = matcher.group();
//                String number = result;
//                int key = Integer.parseInt(matcher.group());
//                if (key >= 0 && key <= 12) {
//                    number = map.get(key);
//                   nextLine =  nextLine.replaceFirst(result, number);
//                }
//            }
            System.out.println(nextLine);
        }
        bufferedReader.close();
    }
}































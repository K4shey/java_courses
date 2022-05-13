package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String[] array = nextLine.toLowerCase().split(" ");
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                String nextWord = array[i].trim();
                for (int j = 0; j < words.size(); j++) {
                    String wordFromList = words.get(j).toLowerCase().trim();
                    if (wordFromList.equals(nextWord)) {
                        count++;
                    }
                }
            }
            if (count == 2) {
                System.out.println(nextLine);
            }
        }
        bufferedReader.close();
    }
}































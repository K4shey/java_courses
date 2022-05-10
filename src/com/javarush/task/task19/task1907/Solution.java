package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/*
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename));
        int count = 0;
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine().toLowerCase(Locale.ROOT);
            String str = nextLine.replaceAll("\\p{P}", " ").replaceAll("\\s", " ");
            String[] array = str.split(" ");
            for (String word : array) {
                if (word.equals("world")) {
                    count++;

                }
            }

//            String[] array = nextLine.split("[;:.,!?\\s]");
//            for (String word: array) {
//                if (word.contains("world") && word.length() == 5) {
//                    if (word.charAt(0) == 'w' && word.charAt(1) == 'o' && word.charAt(2) == 'r'
//                     && word.charAt(3) == 'l' && word.charAt(4) == 'd') {
////                        System.out.println(word);
//                        count++;
//                    }
//                }
//            }

        }
        System.out.println(count);
        bufferedReader.close();
    }
}































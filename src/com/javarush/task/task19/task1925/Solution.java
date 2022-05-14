package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        String filename1 = args[0];
        String filename2 = args[1];
        List <String> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename1));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
            while (bufferedReader.ready()) {
                String nextLine = bufferedReader.readLine();
                String[] wordsArray = nextLine.split(" ");
                for (String word: wordsArray) {
                    if (word.length() > 6) {
                        list.add(word);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i));
                if (i < list.size() -1) {
                    bufferedWriter.write(",");
                }
//                System.out.print(list.get(i));
//                if (i < list.size() -1) {
//                    System.out.print(",");
//                }
            }
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException ioException) {
            System.out.println("Something went wrong " + ioException);
        }
        

    }
}































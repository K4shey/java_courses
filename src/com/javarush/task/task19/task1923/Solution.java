package com.javarush.task.task19.task1923;

import java.io.*;

/*
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename1 = args[0];
        String filename2 = args[1];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String[] wordsArray = nextLine.split(" ");
            for (String nextWord : wordsArray) {
                char[] chars = nextWord.toCharArray();
                for (char ch : chars) {
                    if (Character.isDigit(ch)) {
                        bufferedWriter.write(nextWord + " ");
                        break;
                    }
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}






























package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/*
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        FileReader fileReader = new FileReader(args[0]);
        double countSpaces = 0;
        double countOther = 0;
        while (fileReader.ready()) {
            char nextChar = (char) fileReader.read();
            if (nextChar == ' ') {
                countSpaces++;
            }
            countOther++;

        }
        fileReader.close();
        double value = countSpaces / countOther * 100;
        double result = (int) (value * 100 + 0.5) / 100.0;
        System.out.println(result);
    }
}































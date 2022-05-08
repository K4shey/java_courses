package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }


        FileReader fileReader  = new FileReader(args[0]);
        int count =0;
        while (fileReader.ready()) {
            char nextChar = (char) fileReader.read();
            if ((('a' <= nextChar && nextChar <= 'z') || ('A' <= nextChar && nextChar <= 'Z'))) {
//                System.out.println(nextChar + " " + Character.isLetter(nextChar));
                count++;
            }
        }
        System.out.println(count);
    fileReader.close();
    }
}































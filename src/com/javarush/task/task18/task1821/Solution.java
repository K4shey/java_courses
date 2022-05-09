package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        String filename = args[0];
        FileReader fileReader = new FileReader(filename);
        Map<Character, Integer> treeMap = new TreeMap<>();
        while (fileReader.ready()) {
            char nextChar = (char) fileReader.read();
            if (treeMap.containsKey(nextChar)) {
                Integer tmp = treeMap.get(nextChar) + 1;
                treeMap.put(nextChar, tmp);
            } else {
                treeMap.put(nextChar, 1);
            }
        }
        fileReader.close();
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}































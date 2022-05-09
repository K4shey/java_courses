package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> files = new TreeSet<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nextLine = bufferedReader.readLine();
        while (!nextLine.equals("end")) {
            files.add(nextLine);
            nextLine = bufferedReader.readLine();
        }
        bufferedReader.close();
        String anyFile = files.iterator().next();
        String newName = anyFile.substring(0, anyFile.indexOf(".part"));
        FileOutputStream fileOutputStream = new FileOutputStream(newName);
        for (String filename : files) {
            FileInputStream fileInputStream = new FileInputStream(filename);
            byte[] buffer = new byte[1024];
            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, count);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
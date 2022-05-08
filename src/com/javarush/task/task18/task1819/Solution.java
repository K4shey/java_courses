package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;

/*
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream inputStreamReader = new FileInputStream(filename1);
        byte[] buffer = new byte[inputStreamReader.available()];
        if (inputStreamReader.available() > 0) {
            int count = inputStreamReader.read(buffer);
        }
        inputStreamReader.close();
        inputStreamReader = new FileInputStream(filename2);
        FileOutputStream outputStreamWriter = new FileOutputStream(filename1);
        while (inputStreamReader.available() > 0) {
            outputStreamWriter.write(inputStreamReader.read());
        }
        outputStreamWriter.write(buffer);
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}































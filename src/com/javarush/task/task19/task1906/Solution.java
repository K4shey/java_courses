package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        int count = 0;
        while (fileReader.ready()) {
            int nextChar = fileReader.read();
            count++;
            if (count % 2 == 0) {
                fileWriter.write(nextChar);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}































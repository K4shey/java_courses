package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/*
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename2));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String[] array = nextLine.split(" ");
            Integer number = 0;
            for (String nextString : array) {

                try {
                    number = Integer.parseInt(nextString);
                } catch (Exception E) {
                    continue;
                }
                bufferedWriter.write(String.valueOf(number) + " ");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}































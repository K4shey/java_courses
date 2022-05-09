package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = bufferedReader.readLine();
        String filename2 = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            String[] array = nextLine.split(" ");
            for (String element: array) {
                Long number = Math.round(Double.parseDouble(element));
                fileWriter.write(number.toString() + " ");
            }
        }
        fileWriter.close();
        fileReader.close();
        bufferedReader.close();
    }
}































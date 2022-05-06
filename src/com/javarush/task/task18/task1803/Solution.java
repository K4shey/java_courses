package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int[] array = new int[256];
        Arrays.fill(array, 0);

        while (fileInputStream.available() > 0) {
            int nextPosition = fileInputStream.read();
            array[nextPosition]++;
        }

        int maxOccurrence = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxOccurrence) {
                maxOccurrence = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == maxOccurrence) {
                System.out.print(i + " ");
            }
        }

        fileInputStream.close();
        bufferedReader.close();

    }
}































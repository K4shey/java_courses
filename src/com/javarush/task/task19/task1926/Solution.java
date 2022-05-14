package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(filename));
        while (bufferedReader.ready()) {
            String nextLine = bufferedReader.readLine();
            StringBuilder reverse = new StringBuilder(nextLine).reverse();
            nextLine = reverse.toString();
            System.out.println(nextLine);
        }
        bufferedReader.close();
    }
}































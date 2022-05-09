package com.javarush.task.task18.task1824;

import java.io.*;

/*
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String filename = bufferedReader.readLine();
            try (FileInputStream fileInputStream = new FileInputStream(filename)) {
                fileInputStream.read();
            } catch (FileNotFoundException e) {
                System.out.println(filename);
                break;
            }
        }
    }
}































package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int maxByte = fileInputStream.read();
        while (fileInputStream.available() > 0) {
            int nextByte = fileInputStream.read();
            if(nextByte > maxByte) {
                maxByte = nextByte;
            }
        }
        System.out.println(maxByte);
        bufferedReader.close();
        fileInputStream.close();
    }
}































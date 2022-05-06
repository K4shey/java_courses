package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int minByte = fileInputStream.read();
        while (fileInputStream.available() > 0) {
            int nextByte = fileInputStream.read();
            if(nextByte < minByte) {
                minByte = nextByte;
            }
        }
        System.out.println(minByte);
        bufferedReader.close();
        fileInputStream.close();
    }
}































